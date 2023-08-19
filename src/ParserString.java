public class ParserString {
    String[] operators = new String[] {"\\+", "\\-", "\\*", "\\/"};
    private final String data;
    ParserString(String string){
        this.data = string;
    }


    public int countOperators() {
        String str = this.data;
        int lengthBefore = str.length();
        str = str.replace("+", "");
        str = str.replace("-", "");
        str = str.replace("*", "");
        str = str.replace("/", "");
        int lengthAfter = str.length();
        return lengthBefore - lengthAfter;
    }

    public String[] getOperands() throws Exception {
        int count = this.countOperators();
        String[] result = new String[3];
        if (count == 1){
            for (String operator : operators) {
                if (this.data.contains(operator.replaceAll("\\\\", ""))) {
                    result[0] = this.data.split(operator)[0].trim();
                    result[1] = this.data.split(operator)[1].trim();
                    result[2] = operator.replaceAll("\\\\", "");
                    break;
                }
            }
            return result;
        } else if (count == 0) {
            String exc = "a string is not a mathematical operation";
            throw new Exception(exc);
        } else{
            String exc = "There are " + count + " operators in this line and there should be 1";
            throw new Exception(exc);
        }
    }
}
