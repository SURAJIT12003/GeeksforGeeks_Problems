//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends







class Solution
{
    //Function to check if brackets are balanced or not.
    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (st.isEmpty()) {
                st.push(ch);
            } else {
                if (ch == ')' || ch == '}' || ch == ']') {
                    st.push(ch);
                } else {

                    if (!st.isEmpty()) {

                        if (ch == '(') {
                            char r = st.peek();
                            if(r==')'){
                                st.pop();
                            }
                            else{
                                st.push(ch);
                            }
                        }
                        else if (ch=='{'){
                            char r = st.peek();
                            if(r=='}'){
                                st.pop();
                            }
                            else{
                                st.push(ch);
                            }
                        }
                        else{
                            char r = st.peek();
                            if(r==']'){
                                st.pop();
                            }
                            else{
                                st.push(ch);
                            }
                        }

                    }
                    else{
                        st.push(ch);
                    }

                }
            }
        }

        if(st.isEmpty()){
            return true;
        }
        return false;
    }

    static boolean ispar(String x)
    {
        return check(x);
    }
}
