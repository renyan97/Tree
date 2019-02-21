package suanfa;
/**
 * 1.������������˼·��ÿ���ڴ���Ȩֵ���������ҳ���С�������������������ĺ����丸�׵�ֵ�����������ã�Ȼ�󽫸ø��׼��������С�
 * �ظ��������n-1�Ρ�
 * 2.����������
*/

class tree{
	int left=-1;//�����±�
	int right=-1;//�Һ����±�
	int val=-1;//Ȩֵ
	int parent=-1;//�����±�
	int []bit=new int[10];//ά��һ����Ź��������������
	tree(int v){this.val=v;}
}

public class Huffman {
    static int[] a= {2,3,6,7,10,19,21,32};//��Ȩֵ��Ҷ�ӽڵ�
    static tree[] h= new tree[2*a.length-1];//������Ĺ�������
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʼ��h���� 
		for(int i=0;i<h.length;i++)
	        {
	        	h[i] =new tree(-1);
	        }
		//��h���鸳ֵ
        for(int i=0;i<a.length;i++)
        {
        	h[i].val=a[i];
        }
                     
        Huffman f=new Huffman();
	
        f.init();//������������
		f.print();//��ӡ
		f.Code();//��������
		f.printCode();//��ӡ����������
		
		
	}
	
	
	public void Code()
	{
		for(int i=0;i<a.length;i++)
		{
			int m=i;//�����±�
			int start=h[i].bit.length-1;//��¼�����������е���ʼλ��
			int p=h[m].parent;
			while(p!=-1)//�ж��Ƿ񵽸��ڵ�
			{
			 
				if(h[p].left==m)//�жϸý���Ǹ��׵����ӻ����к���
				     h[i].bit[start]=0;//��ֵ��Ӧ����
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
		System.out.println("�����������룺");
		 for(int i=0;i<a.length;i++)
		 {
			 System.out.print("ȨֵΪ"+h[i].val+"���������룺");
			 for( int j=h[i].bit[0];j<h[i].bit.length;j++)
			 {
				 System.out.print(h[i].bit[j]);
			 }
		 }
		}
	
	public static void print()
	{
		System.out.println("����������");
		 for(int i=0;i<h.length;i++)
	     	System.out.println(" index :"+i+"  "+h[i].val+"parent :"+h[i].parent);
		 System.out.println(" ");
		}
	
	public static void init()
	{
		for(int i=0;i<a.length-1;i++)//��Ҫ����n-1����֧�ڵ�
		{ 
			int m1 = 655,m2=655;//�ҳ���С����ֵ
	        	int x1=0,x2=0;//��Сֵ�������±�
			for(int j=0;j<a.length+i;j++)//ÿ���ҳ���С��������
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
			   int k=i+a.length;//����������Сֵ���׵��±�
	           h[x1].parent=k;
	           h[x2].parent=k;
	           h[k].val = h[x1].val+h[x2].val;
	           h[k].left=x1;
	           h[k].right=x2;
		}
	}

}


 
