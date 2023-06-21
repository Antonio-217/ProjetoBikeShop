package view.util;

//é uma classe que serve como modelo para a jtable da tela de consulta 
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Marca;

//de marcas. Ela é responsavel por configurar o titulo de cada coluna, 
//bem como o numero de linhas, o numero de colunas e também os dados.
public class MarcaTableModel extends AbstractTableModel {

    //lista de marcas
    private ArrayList<Marca> lista;

    public MarcaTableModel(ArrayList<Marca> lista) {
        this.lista = lista;
    }

    //método que diz o numero de linha da jtable
    @Override
    public int getRowCount() {
        return lista.size();
    }

    //método que define o numero de colunas da tabela
    @Override
    public int getColumnCount() {
        return 2;
    }

    //este método retorna o valor de cada célula
    @Override                //linha       //coluna
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca m = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getCodMarca();
            case 1:
                return m.getNomeMarca();
            default:
                return "ERRO";
        }
    }

    //define o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            default:
                return "ERRO";
        }
    }
    
    //método que devolve a marca referente 
    //a linha que foi clicada
    public Marca getMarca(int linha){
        return lista.get(linha);
    }

}
