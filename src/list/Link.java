package list;

/**
 * @author Letmesea
 * @title: ListNode 带头结点链表
 * @projectName leetCode
 * @description: TODO
 * @date 2019/11/119:12
 */
public class Link {
    private Node head;
    Link(){
        this.head=new Node();
    }

    /**
     * 头插法
     * @param val
     */
    public void linkFirst(int val){
        Node curr = new Node(val);
        curr.next=head.next;
        head.next=curr;
    }

    /**
     * 尾插法
     * @param val
     */
    public void linkLast(int val){
        Node tmp=head;
        Node curr = new Node(val);
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=curr;
        curr.next=null;
    }

    /**
     * 合并两个有序链表
     */
    public Node mergeTwoLists(Node l1,Node l2){
        Node node = new Node();
        Node p=node;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        p.next=l1==null?l2:l1;
        return node.next;
    }

    /**
     * 回文链表  1-2-2-2-1
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head) {
        if(head==null||head.next==null){
            return true;
        }
        Node f=head;
        Node s=head;
        while (f.next!=null&&f.next.next!=null){
            f=f.next.next;
            s=s.next;
        }
        s=reverseLink(s.next);
        while (s!=null){
            if(s.val!=head.val){
                return false;
            }
            s=s.next;
            head=head.next;
        }
        return true;
    }

    /**
     * 反转链表,返回结果不带头结点
     * @param head
     * @return
     */
    public Node reverseLink(Node head){
        Node tmp,pre=null;
        Node q = head;
        while (q!=null){
            tmp=q.next;
            q.next=pre;
            pre=q;
            q=tmp;
        }
        return pre;
    }

    /**
     * 判断是否是环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if(head==null||head.next==null){
            return false;
        }
        Node f = head;
        Node s = head;
        while (f.next!=null&&f.next.next!=null){
            f=f.next.next;
            s=s.next;
            if(f.val==s.val){
                return true;
            }
        }
        return false;
    }
    private static class Node {
        int val;
        Node next;

        Node() {
            this.val = -1;
            this.next = null;
        }

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String [] v){
        Link link = new Link();
        link.linkLast(1);
        link.linkLast(2);
        link.linkLast(3);
        Node p = link.head;
//        Node n = link.reverseLink(link.head.next);
//        boolean re = link.isPalindrome(link.head.next);
        while (p.next!=null){
            p=p.next;
        }
        p.next=link.head.next.next;
        boolean re = link.hasCycle(link.head.next);
        System.out.println(11);
    }
}

