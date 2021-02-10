package dynamic_stacks_queues;

/**
 *
 * @author Polis
 */
public class ParenthesesCheck {
    
    public static void main(String args[]) {
        
        String str;
        
        System.out.print("Please type: ");
        str = UserInput.getString();
        System.out.println(isBalanced(str));
    }

    private static boolean isBalanced(String str) {
        LinkedStack ls = new LinkedStack();
        char charToCheck;
        
        for (int i=0; i<str.length(); i++) {
            charToCheck = str.charAt(i);
            
            switch((char)str.charAt(i)) {
                case '(':
                    ls.push((char)str.charAt(i));
                    break;
                case '[':
                    ls.push((char)str.charAt(i));
                    break;
                case '{':
                    ls.push((char)str.charAt(i));
                    break;
                case '}':
                    if(ls.isEmpty() || !(ls.pop().equals('{'))) {
                        System.out.println("Error at position: "+(i));
                        return false;
                    }
                    break;
                case ']':
                    if(ls.isEmpty() || !(ls.pop().equals('['))) {
                        System.out.println("Error at position: "+(i));
                        return false;
                    }
                    break;
                case ')':
                    if(ls.isEmpty() || !(ls.pop().equals('('))) {
                        System.out.println("Error at position: "+(i));
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(ls.isEmpty()) {
            System.out.println("No error.");
            return true;
        }else {
            System.out.println("Error at position: "+str.length());
            return false;
        }
    }
}