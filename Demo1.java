package suanfa;
import java.util.*;
/**
 * �ؽ�������
 * */
class TreeNode {
    int val;//Ȩֵ
    TreeNode left;//����
    TreeNode right;//�Һ���
    TreeNode(int x) { val = x; }
}
public class Demo1 {
	static int i=0;
	static	int [] pre= {1,2,4,7,3,5,6,8};//�������
	static	int [] in= {4,7,2,1,5,3,8,6};//�������
	public static void main(String[] args) {
	 
		 if(pre==null||in==null)
            System.out.println("�޷��ؽ�");
        
          TreeNode root=f(pre,0,pre.length-1,in,0,pre.length-1);
           f(root);//�������
	
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
        if(i>j||k>h)//i,j,h,k�ֱ�Ϊp,in��������½�
            return null;
        TreeNode t=new TreeNode(p[i]);//����һ����㲢��ֵ ������������ȡ��һ��ֵ
        int m=0;
        while(p[i]!=in[m])
            m++;//�ҵ������������е�λ��
        t.left=f(p,i+1,i+m-k,in,k,m-1);//
        t.right=f(p,i+m-k+1,j,in,m+1,h);// 
        return t;
    }
}

 
	  
