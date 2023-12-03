public class BST<T extends Comparable<T>> {
    protected BSTNode<T> root, current;

    
    public BST() {
        root = current = null;
    }

    
    
    public boolean empty() {
        return root == null;
    }

    public boolean full() {
        return false;
    }

    public T retrieve() {
        return current.data;
    }

    public boolean findKey(String tkey) {
        BSTNode<T> p = root, q = root;

        if (empty())
            return false;

        while (p != null) {
            q = p;
            int comparisonResult = p.key.compareTo(tkey);
            if (comparisonResult == 0) {
                current = p;
                return true;
            } else if (comparisonResult > 0)
                p = p.left;
            else
                p = p.right;
        }

        current = q;
        return false;
        /*Time Complexity O(Log n)*/
    }

    public boolean insert(String k, T val) {
        BSTNode<T> p, q = current;

        if (findKey(k)) {
            current = q;
            return false;
        }

        p = new BSTNode<T>(k, val);
        if (empty()) {
            root = current = p;
            return true;
        } else {
            
            int comparisonResult = current.key.compareTo(k);
            if (comparisonResult > 0)
                current.left = p;
            else
                current.right = p;
            current = p;
            return true;
        }
        //Time Complexity O(n)
    }  

    private BSTNode<T> findMin(BSTNode<T> p) {
        if (p == null)
            return null;

        while (p.left != null) {
            p = p.left;
        }

        return p;
        /*Time Complexity O(Log n)*/
    }

    private BSTNode<T> removeAux(String key, BSTNode<T> p, Boolean flag) {
        BSTNode<T> q, child = null;
        if (p == null)
            return null;
        int comparisonResult = p.key.compareTo(key);
        if (comparisonResult > 0)
            p.left = removeAux(key, p.left, flag); 
        else if (comparisonResult < 0)
            p.right = removeAux(key, p.right, flag); 
        else { // key is found
            flag = true;
            if (p.left != null && p.right != null) { 
                q = findMin(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = removeAux(q.key, p.right, flag);
            } else {
                if (p.right == null) 
                    child = p.left;
                else if (p.left == null) 
                    child = p.right;
                return child;
            }
        }
        return p;
        /*Time Complexity O(Log n)*/
    } public boolean removeKey(String tkey) {
        Boolean removed =  false ;
        BSTNode<T> p;
        p = removeAux(tkey, root, removed);
        current = root = p;
        return removed;
        /*Time Complexity O(Log n)*/
    }
    

    


	


}