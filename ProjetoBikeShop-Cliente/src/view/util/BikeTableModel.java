
package view.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Bike;

public class BikeTableModel extends AbstractTableModel{

    ArrayList<Bike> listaBikes;

    public BikeTableModel(ArrayList<Bike> listaBikes) {
        this.listaBikes = listaBikes;
    }
    
    @Override
    public int getRowCount() {
        return listaBikes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Bike bk = listaBikes.get(rowIndex);
       
        switch (columnIndex) {
            case 0: return bk.getCodBike();
            case 1: return bk.getModelo();
            case 2: return bk.getMarca().getNomeMarca();
            case 3: return bk.getPrecoString();
            case 4: return bk.getDataLancamentoString();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código";
            case 1: return "Modelo";
            case 2: return "Marca";
            case 3: return "Preço";
            case 4: return "Data Lançamento";
            default: return "NoName";
        }
    }

    public Bike getBike (int row) {
        return listaBikes.get(row);
    } 
}
