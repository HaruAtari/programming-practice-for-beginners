package com.haruatari.task19;

final class Task {
    protected Node firstNode = null;
    protected Node lastNode = null;

    public Task(Node firstNode, Node lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }

    public Node findByValue(String value) {
        var n = firstNode;
        while (n!=null){
           if(n.value.equals(value)){
               return n;
            }
           n=n.next;
        }
        return null; // TODO: Remove this line and put your code here.
    }

    public Node findByIndex(int index) {
        var n = firstNode;
        var i =0;
        while (i<=index){
            if(n==null){
                return null;
            }
            if(i==index){
                return n;
            }

            n=n.next;
            i++;
        }
        return null; // TODO: Remove this line and put your code here.
    }
}
