package base.btree;

import java.util.*;

/**
 * @author Letmesea
 * @title: BinaryTree
 * @projectName leetCode
 * @description: TODO
 * @date 2019/11/1316:05
 */
public class BinaryTree<T extends Comparable<T>> {

    private Entry<T> root;
    private int size = 0;

    public BinaryTree() {
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
//        int[] a = {6,5,3,4,7,2,8};
//        for(int i :a){
//            bt.put(i);
//        }
//        bt.prevIterator(bt.root);
        bt.root = new Entry<Integer>(1);
        bt.root.left = new Entry<Integer>(2);
        bt.root.right = new Entry<Integer>(2);
        bt.root.left.left = new Entry<Integer>(3);
//        bt.root.left.right = new Entry<Integer>(4);
        bt.root.right.left = new Entry<Integer>(3);
//        bt.root.right.right = new Entry<Integer>(4);
//        bt.root.left.left = new Entry<>(4);
//        bt.root.left.right = new Entry<>(5);
//        boolean res = bt.isValidBST(bt.root);
        boolean res1 = bt.isSymmetric1(bt.root);
        boolean res2 = bt.isSymmetric2(bt.root);
        List<List<Integer>> lists = bt.levelOrder(bt.root);
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Entry<Integer> root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1;
        if(root==null){
            return list;
        }
        Queue<Entry<Integer>> queue = new ArrayDeque();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            list1 = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Entry<Integer> node = queue.poll();
                list1.add(node.item);
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
            list.add(list1);
        }
        return list;
    }

    /**
     * 判断是否对称--迭代
     * @param root
     * @return
     */
    public boolean isSymmetric1(Entry<Integer> root){
        if (root == null) {
            return true;
        }
        Entry<Integer> p1=root;
        Entry<Integer> p2=root;
        Stack<Entry<Integer>> s1 = new Stack<Entry<Integer>>();
        Stack<Entry<Integer>> s2 = new Stack<Entry<Integer>>();
        Entry<Integer> node1,node2;
        do {
            int i=0,j=0;
            while (p1 != null) {
                s1.push(p1);
                p1 = p1.left;
                i++;
            }
            while (p2!=null){
                s2.push(p2);
                p2 = p2.right;
                j++;
            }
            if(i!=j)return false;
            if (!s1.isEmpty()&&!s2.isEmpty()) {
                node1 = s1.pop();
                node2 = s2.pop();
                if (node1.item!=node2.item) {
                    return false;
                }
                p1 = node1.right;
                p2 = node2.left;
            }
        } while ((!s1.isEmpty() || p1 != null)&&(!s2.isEmpty() || p2 != null));
        return true;
    }

    /**
     * 判断是否对称--递归
     * @param root
     * @return
     */
    public boolean isSymmetric2(Entry<Integer> root) {
        if (root == null) {
            return true;
        }
        return mioror(root.left, root.right);
    }
    private boolean mioror(Entry<Integer> t1, Entry<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.item != t2.item) {
            return false;
        }
        return mioror(t1.left, t2.right) && mioror(t1.right, t2.left);
    }
    /**
     * 判断是否对称--迭代和递归
     * @param root
     * @return
     */
    public boolean isSymmetric(Entry<Integer> root) {
        if(root==null){
            return true;
        }
        List<Entry<Integer>> llist = new ArrayList<>();
        List<Entry<Integer>> rlist = new ArrayList<>();
        llist.add(root);
        rlist.add(root);
        prevIteratorL(root.left,llist);
        prevIteratorR(root.right,rlist);
        int llen = llist.size();
        int rlen = rlist.size();
        if(llen==rlen){
            for (int i=0;i<llen;i++){
                if(llist.get(i).left!=null&&rlist.get(i).right!=null){
                    if(llist.get(i).left.item!=rlist.get(i).right.item){
                        return false;
                    }
                }
                if(llist.get(i).left==null&&rlist.get(i).right!=null){
                    return false;
                }
                if(llist.get(i).left!=null&&rlist.get(i).right==null){
                    return false;
                }
                if(llist.get(i).right!=null&&rlist.get(i).left!=null){
                    if(llist.get(i).right.item!=rlist.get(i).left.item){
                        return false;
                    }
                }
                if(llist.get(i).right==null&&rlist.get(i).left!=null){
                    return false;
                }
                if(llist.get(i).right!=null&&rlist.get(i).left==null){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
    public void prevIteratorL(Entry<Integer> e,List<Entry<Integer>> llist) {
        if (e != null) {
            llist.add(e);
            prevIteratorL(e.left,llist);
            prevIteratorL(e.right,llist);
        }
    }
    public void prevIteratorR(Entry<Integer> e,List<Entry<Integer>> rlist) {
        if (e != null) {
            rlist.add(e);
            prevIteratorR(e.right,rlist);
            prevIteratorR(e.left,rlist);

        }
    }
    /**
     * 判断是否二叉搜索树--迭代
     *
     * @param root
     * @return
     */
    public boolean isValidBST(Entry<Integer> root) {
        double cint  = -Double.MAX_VALUE;
        if (root == null) {
            return true;
        }
        Stack<Entry<Integer>> s = new Stack<Entry<Integer>>();
        do {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                Entry<Integer> node = s.pop();
                if (node.item<=cint) {
                    return false;
                }
                cint = node.item;
                root = node.right;
            }
        } while (!s.isEmpty() || root != null);
        return true;
    }

    /**
     * 判断是否二叉搜索树--递归
     * @param root
     * @return
     */
    public boolean isValidBST1(Entry<Integer> root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Entry<Integer> root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.item >= maxVal || root.item <= minVal) return false;
        return isValidBST(root.left, minVal, root.item) && isValidBST(root.right, root.item, maxVal);
    }

    /**
     * 添加元素
     *
     * @param item 待添加元素
     * @return 已添加元素
     */
    public T put(T item) {
        Entry<T> t = root;
        size++;
        if (t == null) {
            root = new Entry<>(item, null);
            return root.item;
        }
        int ret = 0;
        Entry<T> p = t;
        while (t != null) {
            ret = item.compareTo(t.item);
            p = t;
            if (ret < 0)
                t = t.left;
            else if (ret > 0)
                t = t.right;
            else {
                t.item = item;
                return t.item;
            }
        }
        Entry<T> e = new Entry<>(item, p);
        if (ret < 0)
            p.left = e;
        else
            p.right = e;
        return e.item;
    }

    public void print() {
        midIterator(root);
    }

    /**
     * 中序遍历
     *
     * @param e
     */
    public void midIterator(Entry<T> e) {
        if (e != null) {
            midIterator(e.left);
            System.out.print(e.item + " ");
            midIterator(e.right);
        }
    }

    /**
     * 获取根节点
     *
     * @return 根节点
     */
    public Entry<T> getRoot() {
        return root;
    }

    /**
     * 前序遍历
     *
     * @param e 开始遍历元素
     */
    public void prevIterator(Entry<T> e) {
        if (e != null) {
            System.out.print(e.item + " ");
            prevIterator(e.left);
            prevIterator(e.right);
        }
    }

    /**
     * 后续遍历
     *
     * @param e 开始遍历元素
     */
    public void subIterator(Entry<T> e) {
        if (e != null) {
            subIterator(e.left);
            subIterator(e.right);
            System.out.print(e.item + " ");
        }
    }

    private Entry<T> getEntry(T item) {
        Entry<T> t = root;
        int ret;
        for (; t != null; ) {
            ret = item.compareTo(t.item);
            if (ret < 0)
                t = t.left;
            else if (ret > 0)
                t = t.right;
            else
                return t;
        }
        return null;
    }

    /**
     * 判断是否存在该元素
     *
     * @param item 查找元素
     * @return 结果
     */
    public boolean contains(T item) {
        return getEntry(item) != null;
    }

    /**
     * 删除元素
     *
     * @param item 删除元素
     * @return 删除结果
     */
    public boolean remove(T item) {
        Entry<T> delEntry = getEntry(item);
        if (delEntry == null) return false;
        Entry<T> p = delEntry.parent;
        size--;
        if (delEntry.left == null && delEntry.right == null) {
            if (delEntry == root) {
                root = null;
            } else {
                if (delEntry == p.left) {
                    p.left = null;
                } else {
                    p.right = null;
                }
            }
        } else if (delEntry.right == null) {//只有左节点
            Entry<T> lc = delEntry.left;
            if (p == null) {
                lc.parent = null;
                root = lc;
            } else {
                if (delEntry == p.left) {
                    p.left = lc;
                } else {
                    p.right = lc;
                }
                lc.parent = p;
            }
        } else if (delEntry.left == null) {//只有右节点
            Entry<T> rc = delEntry.right;
            if (p == null) {
                rc.parent = null;
                root = rc;
            } else {
                if (delEntry == p.left)
                    p.left = rc;
                else
                    p.right = rc;
                rc.parent = p;
            }
        } else {//有两个节点,找到后继节点，将值赋给删除节点，然后将后继节点删除掉即可
            Entry<T> successor = successor(delEntry);//获取到后继节点
            delEntry.item = successor.item;
            if (delEntry.right == successor) {//后继节点为右子节点，
                if (successor.right != null) {//右子节点有右子节点
                    delEntry.right = successor.right;
                    successor.right.parent = delEntry;
                } else {//右子节点没有子节点
                    delEntry.right = null;
                }
            } else {
                successor.parent.left = null;
            }
            return true;
        }
        delEntry.parent = null;
        delEntry.left = null;
        delEntry.right = null;
        return true;
    }

    /**
     * 查找后继节点
     *
     * @param delEntry 删除节点
     * @return 后继节点
     */
    private Entry<T> successor(Entry<T> delEntry) {
        Entry<T> r = delEntry.right;//assert r != null;
        while (r.left != null) {
            r = r.left;
        }
        return r;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        clear(getRoot());
        root = null;
    }

    private void clear(Entry<T> e) {
        if (e != null) {
            clear(e.left);
            e.left = null;
            clear(e.right);
            e.right = null;
        }
    }

    static final class Entry<T extends Comparable<T>> {
        private T item;
        private Entry<T> left;
        private Entry<T> right;
        private Entry<T> parent;

        Entry(T item, Entry<T> parent) {
            this.item = item;
            this.parent = parent;
        }

        Entry(T item) {
            this.item = item;
        }
    }

}
