package testleetcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;

public class TestLeetCode implements Iterable<Integer>{
    public static void main(String[] args) {
        // ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        // ListNode rs = addTwoNumbers(l1,l2);
        // System.out.println(rs);
        // System.out.println(lengthOfLongestSubstring("ohomm"));
        // int[] num1 = new int[] {1,2};
        // int[] num2 = new int[] {3,4};
        // System.out.println(findMedianSortedArrays(num1, num2));
        // System.out.println(isValid("{}"));
        

    }

    public TestLeetCode(Reader inp) {
    };

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public static int solutions(String S) {

        int count = 0;
        try {
            long v = Long.parseUnsignedLong(S, 2);
            // v is a non-negative number
            while (v > 0) {
                if (v % 2 == 0) {
                    v = v/2;
                } else {
                    v = v - 1;
                }
                count++;
            }

        } catch (NumberFormatException ex) {
        }
        return count;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;
		while(slow.next != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isCycle = true;
				break;
			}
		}
		if (!isCycle)
			return null;
		fast = head;
		while (slow != fast) {
			slow = slow.next;fast = fast.next;
		}
		return fast;
    }

    public static boolean isValid(String s) {
        // Stack<String> strings;
        if (s == null || s.equals("")) return false;
        if (s.length() % 2 == 0) {
            String[] strings = s.split("");
            for (int i = 0; i<strings.length - 1;i = i+2) {
                switch(strings[i]) {
                    case "{":
                        if (strings[i+1].equals("}")) {
                            break;
                        }
                        return false;
                    case "[":
                        if (strings[i+1].equals("]")) {
                            break;
                        }
                        return false;
                    case "(":
                        if (strings[i+1].equals(")")) {
                            break;
                        }
                        return false;
                    default:
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        double result = 0;
        int avgLength = (nums1.length + nums2.length) / 2;
        int[] resultArr = new int[avgLength+1];
        int i = 0, j = 0, z = 0;
        while (i < nums1.length && j < nums2.length && z < avgLength + 1) {
            if (nums1[i] < nums2[j]) {
                resultArr[z] = nums1[i];
                i++;
            } else {
                resultArr[z] = nums2[j];
                j++;
            }
            z++;
        }
        while (i < nums1.length && z < avgLength + 1) {
            resultArr[z] = nums1[i];
            i++;
            z++;
        }
        while (j < nums2.length && z < avgLength + 1) {
            resultArr[z] = nums2[j];
            j++;
            z++;
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            result = (double) (resultArr[resultArr.length - 1] + resultArr[resultArr.length - 2]) / 2;
        } else {
            result = resultArr[resultArr.length - 1];
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        if (s.trim().equals("")) return 1;
        StringBuilder result = new StringBuilder();
        String[] strings = s.split("");
        int max = 0;
        int i = 0;
        while (i < strings.length) {
            if (result.toString().contains(strings[i])) {
                String newResult = result.substring(result.indexOf(strings[i]) + 1);
                result = new StringBuilder();
                result.append(newResult);
                result.append(strings[i]);
            } else {
                result.append(strings[i]);
                if (max < result.length()) {
                    max = result.length();
                }
            }
            i++;
        }
        return max;
    }

    /**
     * @description addTwoNumber
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int i1 = 0;
        int i2 = 0;
        while (l1.next != null) {
            map1.put(i1, l1.val);
            l1 = l1.next;
            i1++;
        }
        map1.put(i1, l1.val);
        while (l2.next != null) {
            map2.put(i2, l2.val);
            l2 = l2.next;
            i2++;
        }
        map2.put(i2, l2.val);
        int afterminus10 = 0;
        HashMap<Integer, Integer> rs = new HashMap<>();
        if (map1.size() < map2.size()) {
            for (int i = 0; i < map1.size(); i++) {
                int sum = map1.get(i) + map2.get(i) + afterminus10;
                if (sum > 9) {
                    afterminus10 = 1;
                    rs.put(i, sum - 10);
                } else {
                    afterminus10 = 0;
                    rs.put(i, sum);
                }
            }
            for (int i = map1.size(); i < map2.size(); i++) {
                int sum = afterminus10 + map2.get(i);
                if (sum > 9) {
                    afterminus10 = 1;
                    rs.put(i, sum - 10);
                } else {
                    afterminus10 = 0;
                    rs.put(i, sum);
                }
            }
        } else {
            for (int i = 0; i < map2.size(); i++) {
                int sum = map1.get(i) + map2.get(i) + afterminus10;
                if (sum > 9) {
                    afterminus10 = 1;
                    rs.put(i, sum - 10);
                } else {
                    afterminus10 = 0;
                    rs.put(i, sum);
                }
            }
            for (int i = map2.size(); i < map1.size(); i++) {
                int sum = afterminus10 + map1.get(i);
                if (sum > 9) {
                    afterminus10 = 1;
                    rs.put(i, sum - 10);
                } else {
                    afterminus10 = 0;
                    rs.put(i, sum);
                }
            }
        }
        if (afterminus10 > 0) {
            rs.put(rs.size(), 1);
        }
        ListNode listNode = new ListNode(rs.get(0));
        ListNode curr = listNode;
        for (int i = 1; i< rs.size(); i++) {
            curr.next = new ListNode(rs.get(i));
            curr = curr.next;
        }
        return listNode;
    }
    // private ListNode addListNode(ListNode listNode) {


    // }
}
