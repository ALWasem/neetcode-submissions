class TreeNode {

    int key;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int key, int val){
        this.key = key;
        this.val = val;
    }

}

class TreeMap {

    TreeNode root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {

        TreeNode newNode = new TreeNode(key, val);
        TreeNode curr = this.root;
        TreeNode parent = null;

        if(this.root == null){
            this.root = newNode;
            return;
        }

        while(curr != null){
            parent = curr;
            if(key < curr.key)
                curr = curr.left;
            else if(key > curr.key)
                curr = curr.right;
            else{
                curr.val = val;
                return;
            } 
        }

        if(key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

    }

    public int get(int key) {

        TreeNode curr = this.root;

        while(curr != null){
            if(key < curr.key)
                curr = curr.left;
            else if(key > curr.key)
                curr = curr.right;
            else
                return curr.val;
        }

        return -1;

    }

    public int getMin() {

        TreeNode curr = this.root;

        if(curr == null)
            return -1;

        while(curr.left != null){
            curr = curr.left;
        }

        return curr.val;

    }

    public int getMax() {

        TreeNode curr = this.root;

        if(curr == null)
            return -1;

        while(curr.right != null){
            curr = curr.right;
        }

        return curr.val;

    }

    public void remove(int key) {

        this.root = recursiveRemove(this.root, key);
       
    }

    public TreeNode recursiveRemove(TreeNode root, int key){

        if(root == null)
            return null;
        
        if(key < root.key)
            root.left = recursiveRemove(root.left, key);
        else if(key > root.key)
            root.right = recursiveRemove(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                TreeNode min = minNode(root.right);
                root.key = min.key;
                root.val = min.val;
                root.right = recursiveRemove(root.right, min.key);
            }
        }

        return root;

    }

    public TreeNode minNode(TreeNode node){
        while(node != null && node.left != null)
            node = node.left;
        return node;
    }

    public List<Integer> getInorderKeys() {
        
        List<Integer> order = new ArrayList<>();

        inOrder(this.root, order);

        return order;

    }

    public void inOrder(TreeNode root, List<Integer> arr){

        if(root == null)
            return;
        inOrder(root.left, arr);
        arr.add(root.key);
        inOrder(root.right, arr);
    }
}
