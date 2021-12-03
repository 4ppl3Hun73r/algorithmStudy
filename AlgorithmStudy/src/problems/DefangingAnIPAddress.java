package problems;

// https://leetcode.com/problems/defanging-an-ip-address/
public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {

        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}
