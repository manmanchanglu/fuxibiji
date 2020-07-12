/*面试题45. 把数组排成最小的数
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
示例 1:
输入: [10,2]
输出: "102"
示例 2:
输入: [3,30,34,5,9]
输出: "3033459"*/
//思路：先将整形数组转成字符数组(也防止整数溢出)，然后对其进行排序，最后在转成字符串即可
class Solution {
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();

    }
}
/*通常情况下，我们通常直接使用此方法对数组等进行排序，其实还有一种自定义比较器制定比较规则的方法：
sort(T[] a, Comparator<? super T> c) 
继承此方法的时候，要自定义比较器，conpareTo方法返回值为1(升序),0，-1(降序)。
Arrays.sort(str,new Comparator<String>(){            
	@Override            
	public int compare(String s1, String s2) {                
		String c1 = s1 + s2;                
		String c2 = s2 + s1;                
		return c1.compareTo(c2);            
		}        
		}); */      
//此句可进行优化,lamada表达式      
//Arrays.sort(str,(s1,s2)->(s1+s2).compareTo(s2+s1));
