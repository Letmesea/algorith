package base.huawei.face.string;

/**
 * @author Letmesea
 * @title: AddTwoNumbers
 * @projectName algorith
 * @description: TODO
 * @date 2020/4/114:40
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode newnode = p;
        int jin = 0;
        boolean l1b = false;
        boolean l2b = false;
        while (l1!=null&&l2!=null){
            int a1 = l1.val;
            int a2 = l2.val;
            if(a1+a2+jin>=10){
                newnode.next= new ListNode((a1+a2+jin)%10);
                jin = 1;
            }else{
                newnode.next = new ListNode(a1+a2+jin);
                jin  = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            newnode = newnode.next;
        }
        if(l1!=null){
            do{
                if(jin+l1.val>=10){
                    newnode.next=new ListNode((jin+l1.val)%10);
                    jin=1;
                }else{
                    newnode.next=new ListNode(jin+l1.val);
                    jin=0;
                }
                l1 = l1.next;
                newnode = newnode.next;
            }while (l1!=null);
            l1b = true;
        }else if(l2!=null){
            do{
                if(jin+l2.val>=10){
                    newnode.next=new ListNode((jin+l2.val)%10);
                    jin=1;
                }else{
                    newnode.next=new ListNode(jin+l2.val);
                    jin=0;
                }
                l2 = l2.next;
                newnode = newnode.next;
            }while (l2!=null);
            l2b  = true;
        }else{
            newnode.next = jin>0?new ListNode(jin):null;
            jin = 0;
        }
        if(l1b||l2b)
            newnode.next = jin>0?new ListNode(jin):null;
        return p.next;
    }
    public static void main(String[] args){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(1);l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(9);l2.next = new ListNode(9);
//        l2.next = new ListNode(9);l2.next.next = new ListNode(9);
        addTwoNumbers.addTwoNumbers(l1,l2);
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
