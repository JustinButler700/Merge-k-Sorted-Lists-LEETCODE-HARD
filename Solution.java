/*
Made by Justin Butler
10/2/2021
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists.length==0){return null;}
        List<Integer> arr = new ArrayList(); // we will use this as a queue to hold all elements
        boolean empty = true; 
        for(int i = 0; i < lists.length; i++)
        {
            if(lists[i]!=null)
            {
                while(lists[i] != null)
                {
                    arr.add(lists[i].val);
                    lists[i] = lists[i].next;
                    empty = false;
                }   
            }
        }
        if(empty){return null;} // this handles the edge case of [[], [], []] etc.
        Collections.sort(arr);
        ListNode result = new ListNode(arr.get(0));
        arr.remove(0); // FIFO structured Linked List Construction
        ListNode curr = result;
        while(!arr.isEmpty())
        {
            curr.next = new ListNode(arr.get(0));
            arr.remove(0);
            curr = curr.next;
        }
        return result;
        
    }
}
