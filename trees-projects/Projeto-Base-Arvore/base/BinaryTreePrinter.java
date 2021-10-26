package base;
import java.io.PrintStream;

//Código adaptado de https://github.com/eugenp/tutorials

public class BinaryTreePrinter <T extends No> {

    private AbstractArvoreBinariaDePesquisa<T> tree;

    public BinaryTreePrinter(AbstractArvoreBinariaDePesquisa<T> tree) {
        this.tree = tree;
    }

    private String traversePreOrder(No root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getChave());

        String pointerRight = "└──";
        String pointerLeft = (root.getDireita() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getEsquerda(), root.getDireita() != null);
        traverseNodes(sb, "", pointerRight, root.getDireita(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, No node,
        boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getChave());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getDireita() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getEsquerda(), node.getDireita() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getDireita(), false);

        }

    }

    public void imprimir(PrintStream os) {
        os.print(traversePreOrder(tree.raiz));
    }

}