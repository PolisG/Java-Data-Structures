package array_stack;

/**
 *
 * @author Polis
 */
public class ParenthesesCheck {
    public static void main(String[] args) {
        
        String expression;
        
        do {
            System.out.println("Dwse mia arithmitiki parastasi me ()[]{}");
            System.out.print("Alliws \"-e\" gia termatismo: ");
            expression = UserInput.getString();
            
            if(expression.equals("-e"))
                return;
            
            ParenthesesCheck pc = new ParenthesesCheck(expression.length());
            pc.insertParenthesesAtStack(expression);    // gia tis parentheseis()
            pc.insertAgkylesAtStack(expression);        // gia tis agkyles []
            pc.insertAgkistraAtStack(expression);       // gia ta agkistra {}
        
        }while(true);
    }
    
    ArrayStack arr = new ArrayStack();
    int counter = 0;

    private ParenthesesCheck(int length) {
        arr = new ArrayStack(length);
    }

    private void insertParenthesesAtStack(String expression) {
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '(') {
                arr.push("(");
            }else {
                if(expression.charAt(i) == ')') {
                    if(arr.isEmpty()) {
                        System.out.println("Result error at position: " + counter);
                        break;
                    }
                    arr.pop();
                }
            }
            counter++;
        }
        
        if(counter == expression.length()) {
            if(arr.isEmpty())
                System.out.println("Result: No error");
            else
                System.out.println("Result error");
        }
    }

    private void insertAgkylesAtStack(String expression) {
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '[') {
                arr.push("[");
            }else {
                if(expression.charAt(i) == ']') {
                    if(arr.isEmpty()) {
                        System.out.println("Result error at position: " + counter);
                        break;
                    }
                    arr.pop();
                }
            }
            counter++;
        }
        
        if(counter == expression.length()) {
            if(arr.isEmpty())
                System.out.println("Result: No error");
            else
                System.out.println("Result error");
        }
    }

    private void insertAgkistraAtStack(String expression) {
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '{') {
                arr.push("{");
            }else {
                if(expression.charAt(i) == '}') {
                    if(arr.isEmpty()) {
                        System.out.println("Result error at position: " + counter);
                        break;
                    }
                    arr.pop();
                }
            }
            counter++;
        }
        
        if(counter == expression.length()) {
            if(arr.isEmpty())
                System.out.println("Result: No error");
            else
                System.out.println("Result error");
        }
    }
}
