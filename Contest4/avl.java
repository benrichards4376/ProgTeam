import java.util.*;
public class avl
{
    static boolean flag;
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        // int [] a = new int[c];
        // for (int i = 0; i < c; i++)
        //     a[i] = in.nextInt();
        for (int i = 0; i < c; i++)
        {
            int [] a = new int[in.nextInt()];
            for (int j = 0; j < a.length; j++)
                a[j] = in.nextInt();

            flag = true;
            String word = "KEEP";
            Node root = null;
            for (int j = 0; j < a.length; j++)
            {
                int temp = a[j];
                //System.out.println("Inserting " + temp);
                root = Node.insert(root, temp);
                if (!flag)
                {
                    word = "REMOVE";
                    break;
                }
            }
            System.out.println("Tree #" + (i+1) + ": " + word);
        }
    }
    public static void printpreorder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printpreorder(root.left);
        printpreorder(root.right);
    }
    // public static boolean solve(Node root)
    // {
    //     if (root == null)
    //         return true;
    //     int r_height = height(root.right);
    //     int l_height = height(root.left);
    //
    //     if (Math.abs(r_height - l_height) > 1)
    //         return false;
    //     return solve(root.left) && solve(root.right);
    // }

}
class Node
{
	int data, height;
	Node left, right;

	Node(int data, int height)
	{
		this.data = data;
        this.height = height;
	}

    public static Node insert(Node root, int data)
    {
        if (root == null)
        {
            return new Node(data, 0);
        }
        else if (data < root.data)
        {
            root.left = insert(root.left, data);
        }
        else if (data > root.data)
        {
            root.right = insert(root.right, data);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        // System.out.println("l = " + l_height + " r = " + r_height);
        if (Math.abs(height(root.left) - height(root.right)) > 1)
            avl.flag = false;

        return root;
    }
    public static int height(Node root)
    {
        if (root == null)
            return -1;

        return root.height;
    }
}
