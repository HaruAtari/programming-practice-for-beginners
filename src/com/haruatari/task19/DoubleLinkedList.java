package com.haruatari.task19;

import com.haruatari.Helper;

import java.util.ArrayList;

public final class DoubleLinkedList {
    protected Node firstNode = null;
    protected Node lastNode = null;

    public DoubleLinkedList(Node firstNode, Node lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }

    public Node findByValue(String value) {
        return null; // TODO: Remove this line and put your code here.
    }

    public Node findByIndex(int index) {
        return null; // TODO: Remove this line and put your code here.
    }

    @Override
    public String toString() {
        var list = new ArrayList<String>();

        var node = firstNode;
        while (node != null) {
            var str = String.valueOf(node);
            if (node.prev == null) {
                str += " <-- firstNode";
            }
            if (node.next == null) {
                str += " <-- lastNode";
            }
            list.add(str);
            node = node.next;
        }

        return "DoubleLinkedList(\n  nodes: " + Helper.alignArray(list.toArray(), 1) + "\n)";
    }
}
