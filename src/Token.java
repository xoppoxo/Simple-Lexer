public class Token {
    private enum TokenType {
        LET, PRINT,
        IDENTIFIER, NUMBER,
        EQUALS, PLUS, MINUS, ASSIGN, SLASH, STAR,
        LPAREN, RPAREN, SEMICOLON,
        EOF
    }

    // Fields for Token Class
    public final TokenType type;
    public final String value;

    // Constructor
    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return type + "(" + value + ")";
    }
}