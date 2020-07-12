/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3

示例 1：
输入: [1,6,3,2,5]
输出: false
示例 2：
输入: [1,3,2,6,5]
输出: true
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
//二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树。

//递归判断，递归截止条件：数组双指针越界
//代码思路：数组先整体判断符不符合上面二叉搜索树的规则，然后再去判断左子树和右子树符不符合，截止条件是双指针碰头，没有左右子树了
//所谓递归就是大的框架里面有小的框架，直到小的框架结束（截止条件），才结束，大框架与小框架的流程是一样的
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        boolean f=false;
        f=bianli(postorder,0,postorder.length-1);
        return f;
    }
    public boolean bianli(int[] postorder,int i,int j){
        if(i>=j)
            return true;
        
        int m=i;
        while(postorder[i]<postorder[j]){  
            i++;//这里不用加上判断是否比根节点小，因为在第一轮的时候就判断过了
        }
        int n=i;
        while(postorder[i]>postorder[j]){
            i++;//这里不用加上判断是否比根节点大，因为在第一轮的时候就判断过了，如果不符合，则i不回等于j
        }
        return i==j&&bianli(postorder,m,n-1)&&bianli(postorder,n,j-1); //i==j用来排除某个子树是不是有不符合要求的节点   
    }
}