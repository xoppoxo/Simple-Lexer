public class Tokenizer {
    // Fields
    private final String input;
    private int pos = 0;

    // Constructor
    public Tokenizer(String input) {
        this.input = input;
    }

    private char peek() {
        return pos >= input.length() ? '\0' : input.charAt(pos);
    }

    private char advance() {
        return input.charAt(pos++);
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public Token nextToken() {
        while (Character.isWhitespace(peek())) {
            advance();
        }

        char curr = peek();
        if (curr == '\0') {
            return new Token(new Token(EOF), "");
        }

        if (isAlpha(curr)) {
            StringBuilder sb = new StringBuilder();
            while (isAlpha(peek()) == true) {
                sb.append(advance());
            }
            String word = sb.toString();
            if (word.equals("LET")) {
                return new Token(Token.TokenType.LET, word);
            }
            else if (word.equals("PRINT")) {
                return new Token(Token.TokenType.PRINT, word);
            }
            return new Token(Token.TokenType.IDENTIFIER, word);
        }
        
        if (isDigit(c)) {
            StringBuilder sb = new StringBuilder();
            while (isDigit(peek())){
                sb.append(advance());
            } 
            return new Token(Token.TokenType.NUMBER, sb.toString());
        }

        switch (advance()) {
            case '=': return new Token(Token.TokenType.ASSIGN, "=");
            case '+': return new Token(Token.TokenType.PLUS, "+");
            case '-': return new Token(Token.TokenType.MINUS, "-");
            case '*': return new Token(Token.TokenType.STAR, "*");
            case '/': return new Token(Token.TokenType.SLASH, "/");
            case '(': return new Token(Token.TokenType.LPAREN, "(");
            case ')': return new Token(Token.TokenType.RPAREN, ")");
            case ';': return new Token(Token.TokenType.SEMICOLON, ";");
        }

        throw new RuntimeException("Unexpected character: " + c);
    }
}