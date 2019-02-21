package suanfa;
import java.util.*;
/**
 * 重建二叉树
 * */
class TreeNode {
    int val;//权值
    TreeNode left;//左孩子
    TreeNode right;//右孩子
    TreeNode(int x) { val = x; }
}
public class Demo1 {
	static int i=0;
	static	int [] pre= {1,2,4,7,3,5,6,8};//先序遍历
	static	int [] in= {4,7,2,1,5,3,8,6};//中序遍历
	public static void main(String[] args) {
	 
		 if(pre==null||in==null)
            System.out.println("无法重建");
        
          TreeNode root=f(pre,0,pre.length-1,in,0,pre.length-1);
           f(root);//先序遍历
	
}
	public static void f(TreeNode t)
	 
	{
		if(t!=null)
		{
		      System.out.println(t.val);
		      f(t.left);
		      f(t.right);
	}}
    public static TreeNode f(int[] p,int i,int j,int[] in,int k,int h)
    {
        if(i>j||k>h)//i,j,h,k分别为p,in数组的上下界
            return null;
        TreeNode t=new TreeNode(p[i]);//创建一个结点并赋值 从先序数组中取出一个值
        int m=0;
        while(p[i]!=in[m])
            m++;//找到在中序数组中的位置
        t.left=f(p,i+1,i+m-k,in,k,m-1);//
        t.right=f(p,i+m-k+1,j,in,m+1,h);// 
        return t;
    }
}

 
	  
