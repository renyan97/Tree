package suanfa;
/**
 * 1.构建哈夫曼树思路：每次在带有权值的数组中找出最小的两个数，这两个数的和是其父亲的值，并互相引用；然后将该父亲加入数组中。
 * 重复上面过程n-1次。
 * 2.哈夫曼编码
*/

class tree{
	int left=-1;//左孩子下标
	int right=-1;//右孩子下标
	int val=-1;//权值
	int parent=-1;//父亲下标
	int []bit=new int[10];//维护一个存放哈夫曼编码的数组
	tree(int v){this.val=v;}
}

public class Huffman {
    static int[] a= {2,3,6,7,10,19,21,32};//带权值的叶子节点
    static tree[] h= new tree[2*a.length-1];//构建后的哈夫曼树
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化h数组 
		for(int i=0;i<h.length;i++)
	        {
	        	h[i] =new tree(-1);
	        }
		//给h数组赋值
        for(int i=0;i<a.length;i++)
        {
        	h[i].val=a[i];
        }
                     
        Huffman f=new Huffman();
	
        f.init();//构建哈夫曼树
		f.print();//打印
		f.Code();//构建编码
		f.printCode();//打印哈夫曼编码
		
		
	}
	
	
	public void Code()
	{
		for(int i=0;i<a.length;i++)
		{
			int m=i;//跟踪下标
			int start=h[i].bit.length-1;//记录编码在数组中的起始位置
			int p=h[m].parent;
			while(p!=-1)//判断是否到根节点
			{
			 
				if(h[p].left==m)//判断该结点是父亲的左孩子还是有孩子
				     h[i].bit[start]=0;//赋值相应编码
				else
					h[i].bit[start]=1;
				start--;
				 
			    m=p;
			    p=h[p].parent ;
			}
			h[i].bit[0]=start+1;
		}
	}
	public static void printCode()
	{
		System.out.println("哈夫曼树编码：");
		 for(int i=0;i<a.length;i++)
		 {
			 System.out.print("权值为"+h[i].val+"哈夫曼编码：");
			 for( int j=h[i].bit[0];j<h[i].bit.length;j++)
			 {
				 System.out.print(h[i].bit[j]);
			 }
		 }
		}
	
	public static void print()
	{
		System.out.println("哈夫曼树：");
		 for(int i=0;i<h.length;i++)
	     	System.out.println(" index :"+i+"  "+h[i].val+"parent :"+h[i].parent);
		 System.out.println(" ");
		}
	
	public static void init()
	{
		for(int i=0;i<a.length-1;i++)//需要构建n-1个分支节点
		{ 
			int m1 = 655,m2=655;//找出最小两个值
	        	int x1=0,x2=0;//最小值的数组下标
			for(int j=0;j<a.length+i;j++)//每次找出最小的两个数
			{
			 
				   
		           if(h[j].parent==-1&&h[j].val<m1)
		           {
		        	   m2=m1;
		        	   x2=x1;
		        	   m1=h[j].val;
		        	   x1=j;
		           }
		           else if(h[j].parent==-1&&h[j].val<m2)
		           {
		        	   m2=h[j].val;
		        	   x2=j;
		           } 
			}
			   int k=i+a.length;//构建两个最小值父亲的下标
	           h[x1].parent=k;
	           h[x2].parent=k;
	           h[k].val = h[x1].val+h[x2].val;
	           h[k].left=x1;
	           h[k].right=x2;
		}
	}

}


 
