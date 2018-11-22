/**
 * @ProjectName: BST
 * @Package: PACKAGE_NAME
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: fanxx
 * @CreateDate: 2018/11/20 13:54
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BST<E extends Comparable<E>> { //对泛型E进行限制. 也就是泛型E要具有可比较性.

    //私有内部类 ,因为对用户是屏蔽的. 用户不需要知道我们内部实现机理是什么样子的.
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root; //根节点
    private int size; //长度

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树中添加新的元素E
    public void add(E e){
        root = add(root, e);
    }

    //向以node为根的二分搜索树种插入元素E , 递归算法
    //在插入的过程中, 我们要不断的转换, 到新的更小的二分搜索树当中.去找到新的元素e真正的应该插入的位置.
    //所以我们要靠参数, 去体现这个变化.

    //递归要看两部分, 第一部分是递归终止的条件.
    //第二部分就是递归调用.
    private Node add(Node node, E e){

        if(node == null){
            size ++;
            //返回插入新节点后二分搜索树的根.
            return new Node(e); //我们要将新建立的节点返回回去.
        }

        //否则的话, 我们要进行递归调用
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){ // 这里就是e.compareTo(node.e) > 0
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树种是否含有元素e
    public boolean contains(E e){

        return contains(root, e); //以根为节点, 查看是否含有元素e
    }

    //看以node为根的二分搜索树种是否含有元素e, 递归算法
    private boolean contains(Node node, E e){

        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }
        else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    //二分搜索树的 前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){

        //递归终止的条件
        if(node == null){
            return;
        }
        //递归组成的逻辑.  -->当熟练使用递归之后, 可以不按照这个规律去写. if(node != null){ code : 进行前序遍历的代码}
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString(){
        //res: 生成字符串的结果
        StringBuilder res = new StringBuilder();
        //前序遍历过程: 先展现左子树, 再展现右子树
        //root根节点
        //depth深度 根节点的深度是0, 根节点的左子树和右子树的深度是1 , 以此类推
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点, 深度为depth的描述二叉树的字符串.
    private void generateBSTString(Node node, int depth, StringBuilder res){

        //generateDepthString :生成一个表达深度的字符串
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        //node.e : 当前节点的元素
        res.append(generateDepthString(depth) + node.e + "\n");
        //递归, 遍历左子树和右子树
        generateBSTString(node.left, depth + 1,  res);
        generateBSTString(node.right, depth + 1, res);
    }

    //主要就是做一个标识, 表示这个节点的层级关系.
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++){ //遍历层级
            res.append("--");
        }
            return res.toString();
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){

        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){

        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }



}
