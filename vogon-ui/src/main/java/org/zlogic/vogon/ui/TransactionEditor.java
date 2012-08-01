/*
 * Vogon personal finance/expense analyzer.
 * License TBD.
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.vogon.ui;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Zlogic
 */
public class TransactionEditor extends javax.swing.JPanel implements TableCellRenderer, TableCellEditor {

	/**
	 * Creates new form TransactionEditor
	 */
	public TransactionEditor() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setMinimumSize(new java.awt.Dimension(0, 60));

        jFormattedTextField1.setText("jFormattedTextField1");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

	@Override
	public JComponent getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		table.setRowHeight(row,isSelected?(int)this.getPreferredSize().getHeight():table.getRowHeight());
		if(isSelected)
			return this;
		return (JComponent) table.getDefaultRenderer(String.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		table.setRowHeight(row,isSelected?(int)this.getPreferredSize().getHeight():table.getRowHeight());
		if(isSelected)
			return this;
		return (JComponent) table.getDefaultEditor(String.class).getTableCellEditorComponent(table, value, isSelected, row, column);
	}

	@Override
	public Object getCellEditorValue() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean stopCellEditing() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void cancelCellEditing() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}