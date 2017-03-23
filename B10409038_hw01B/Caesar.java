
public class Caesar {
    private String Alphabet="qwertyuiopasdfghjklzxcvbnm";   // instance that Alphabet
    private String Plaintext;                               // instance that Plaintext
    private String Ciphertext;                              // instance that Ciphertext
    private int Key;                                        // instance that Key
    //set members of the class "Caesar"
    public Caesar(String input,int key){
        Plaintext=input;
        Key=key;
        Ciphertext=Offset(input,key);
    };
    //function "Offset" is used to compute the Ciphertext
    public String Offset(String input,int key){
        input=input.toLowerCase();                          //change Plaintext to lowercase
        char[] output=new char[input.length()];
        for(int i=0;i<input.length();i++){
        output[i]=Alphabet.charAt((Alphabet.indexOf(input.charAt(i))+key)%26);
        }
        return new String(output);
    }
    //this loop can change Plaintext to Ciphertext
    //ex:Plaintext="asd",key=1
    //first loop:透過轉換得知input[0]=a在字母表的陣列位置
    //陣列位置+key之後，得到新的字母表的陣列位置(預防陣列位置>26，所以mod26取餘數)
    //a->s
    //second loop ...

    //get Ciphertext
    public String getCiphertext(){
        return Ciphertext;
    }
}
