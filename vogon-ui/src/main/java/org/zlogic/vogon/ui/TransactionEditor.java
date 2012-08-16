/*
 * Vogon personal finance/expense analyzer.
 * License TBD.
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.vogon.ui;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import org.zlogic.vogon.data.ExpenseTransaction;
import org.zlogic.vogon.data.FinanceAccount;
import org.zlogic.vogon.data.FinanceData;
import org.zlogic.vogon.data.FinanceTransaction;
import org.zlogic.vogon.data.TransferTransaction;
import org.zlogic.vogon.data.Utils;

/**
 * Transaction editor form. Interacts with model directly.
 *
 * @author Zlogic
 */
public class TransactionEditor extends javax.swing.JPanel implements FinanceData.AccountCreatedEventListener, FinanceData.AccountUpdatedEventListener, FinanceData.AccountDeletedEventListener {

	private static final ResourceBundle messages = ResourceBundle.getBundle("org/zlogic/vogon/ui/messages");

	/**
	 * Creates new form TransactionEditor
	 */
	public TransactionEditor() {
		initComponents();
		initCustomComponents();
	}

	private void initCustomComponents() {
		resetInput();

		jTableComponents.getColumnModel().getColumn(1).setCellRenderer(SumTableCell.getRenderer());
		jTableComponents.getColumnModel().getColumn(1).setCellEditor(SumTableCell.getEditor());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNewExpenseIncome = new javax.swing.JButton();
        jButtonNewTransfer = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelTags = new javax.swing.JLabel();
        jTextFieldTags = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jFormattedTextFieldDate = new javax.swing.JFormattedTextField();
        jButtonAddComponent = new javax.swing.JButton();
        jButtonDeleteComponent = new javax.swing.JButton();
        jScrollPaneComponents = new javax.swing.JScrollPane();
        jTableComponents = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(0, 60));

        jButtonNewExpenseIncome.setText(messages.getString("NEW_EXPENSE_INCOME_TRANSACTION")); // NOI18N
        jButtonNewExpenseIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewExpenseIncomeActionPerformed(evt);
            }
        });

        jButtonNewTransfer.setText(messages.getString("NEW_TRANSFER_TRANSACTION")); // NOI18N
        jButtonNewTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewTransferActionPerformed(evt);
            }
        });

        jLabelName.setText(messages.getString("TRANSACTION_DESCRIPTION")); // NOI18N

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabelTags.setText(messages.getString("TRANSACTION_TAGS")); // NOI18N

        jTextFieldTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTagsActionPerformed(evt);
            }
        });

        jLabelDate.setText(messages.getString("TRANSACTION_DATE")); // NOI18N

        jFormattedTextFieldDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDateActionPerformed(evt);
            }
        });

        jButtonAddComponent.setText(messages.getString("ADD_COMPONENT")); // NOI18N
        jButtonAddComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddComponentActionPerformed(evt);
            }
        });

        jButtonDeleteComponent.setText(messages.getString("DELETE_COMPONENT")); // NOI18N
        jButtonDeleteComponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteComponentActionPerformed(evt);
            }
        });

        jTableComponents.setModel(new TransactionComponentsTableModel());
        jTableComponents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneComponents.setViewportView(jTableComponents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonAddComponent)
                .addGap(18, 18, 18)
                .addComponent(jButtonDeleteComponent)
                .addContainerGap())
            .addComponent(jScrollPaneComponents, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonNewExpenseIncome)
                .addGap(18, 18, 18)
                .addComponent(jButtonNewTransfer)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTags)
                    .addComponent(jLabelDate)
                    .addComponent(jLabelName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldName)
                    .addComponent(jTextFieldTags, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNewExpenseIncome)
                    .addComponent(jButtonNewTransfer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTags)
                    .addComponent(jTextFieldTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate)
                    .addComponent(jFormattedTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddComponent)
                    .addComponent(jButtonDeleteComponent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneComponents, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewExpenseIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewExpenseIncomeActionPerformed
		saveChanges();
		editTransaction(new ExpenseTransaction("", new String[0], new Date())); //NOI18N
		financeData.createTransaction(editedTransaction);
    }//GEN-LAST:event_jButtonNewExpenseIncomeActionPerformed

    private void jButtonDeleteComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteComponentActionPerformed
		if (jTableComponents.getSelectedRow() >= 0)
			((TransactionComponentsTableModel) jTableComponents.getModel()).deleteComponent(jTableComponents.convertRowIndexToModel(jTableComponents.getSelectedRow()));
    }//GEN-LAST:event_jButtonDeleteComponentActionPerformed

    private void jButtonAddComponentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddComponentActionPerformed
		int newComponentIndex = ((TransactionComponentsTableModel) jTableComponents.getModel()).addCompoment();
		jTableComponents.setRowSelectionInterval(newComponentIndex, newComponentIndex);
    }//GEN-LAST:event_jButtonAddComponentActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
		saveChanges();
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTagsActionPerformed
		saveChanges();
    }//GEN-LAST:event_jTextFieldTagsActionPerformed

    private void jFormattedTextFieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDateActionPerformed
		saveChanges();
    }//GEN-LAST:event_jFormattedTextFieldDateActionPerformed

    private void jButtonNewTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewTransferActionPerformed
		saveChanges();
		editTransaction(new TransferTransaction("", new String[0], new Date())); //NOI18N
		financeData.createTransaction(editedTransaction);
    }//GEN-LAST:event_jButtonNewTransferActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddComponent;
    private javax.swing.JButton jButtonDeleteComponent;
    private javax.swing.JButton jButtonNewExpenseIncome;
    private javax.swing.JButton jButtonNewTransfer;
    private javax.swing.JFormattedTextField jFormattedTextFieldDate;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelTags;
    private javax.swing.JScrollPane jScrollPaneComponents;
    private javax.swing.JTable jTableComponents;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldTags;
    // End of variables declaration//GEN-END:variables
	/**
	 * Finance Data instance
	 */
	protected FinanceData financeData;
	/**
	 * The transaction currently being edited
	 */
	protected FinanceTransaction editedTransaction;

	/**
	 * Resets all input fields to default (empty) values)
	 */
	protected void resetInput() {
		jTextFieldName.setText(""); //NOI18N
		jTextFieldTags.setText(""); //NOI18N
		jFormattedTextFieldDate.setText(""); //NOI18N
		((TransactionComponentsTableModel) jTableComponents.getModel()).setTransaction(null);

		jTextFieldName.setEnabled(editedTransaction != null);
		jTextFieldName.setEditable(editedTransaction != null);
		jTextFieldTags.setEnabled(editedTransaction != null);
		jTextFieldTags.setEditable(editedTransaction != null);
		jFormattedTextFieldDate.setEnabled(editedTransaction != null);
		jFormattedTextFieldDate.setEditable(editedTransaction != null);
	}

	/**
	 * Sets the FinanceData reference
	 *
	 * @param financeData the FinanceData instance
	 */
	public void setFinanceData(FinanceData financeData) {
		this.financeData = financeData;
		((TransactionComponentsTableModel) jTableComponents.getModel()).setFinanceData(financeData);
	}

	/**
	 * Updates the account combo box cell editor with all current accounts
	 */
	public void updateAccountsCombo() {
		jTableComponents.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JComboBox(((TransactionComponentsTableModel) jTableComponents.getModel()).getAccountsComboList())));
	}

	/**
	 * Assigns this editor to edit the specified transaction
	 *
	 * @param transaction the transaction to be edited
	 */
	public void editTransaction(FinanceTransaction transaction) {
		if (jTableComponents.getCellEditor() != null)
			jTableComponents.getCellEditor().cancelCellEditing();
		saveChanges();
		editedTransaction = transaction;
		resetInput();
		if (transaction != null) {
			jTextFieldName.setText(transaction.getDescription());
			jTextFieldTags.setText(Utils.join(((FinanceTransaction) transaction).getTags(), ",")); //NOI18N
			jFormattedTextFieldDate.setText(MessageFormat.format(messages.getString("FORMAT_DATE"), new Object[]{transaction.getDate()}));
			((TransactionComponentsTableModel) jTableComponents.getModel()).setTransaction(transaction);
		}
	}

	/**
	 * Saves all changes in the FinanceData persistence
	 */
	protected void saveChanges() {
		if (editedTransaction != null) {
			financeData.setTransactionDescription(editedTransaction, jTextFieldName.getText());
			financeData.setTransactionTags(editedTransaction, jTextFieldTags.getText().split(",")); //NOI18N
			SimpleDateFormat dateFormat = new SimpleDateFormat(messages.getString("PARSER_DATE"));
			try {
				financeData.setTransactionDate(editedTransaction, dateFormat.parse(jFormattedTextFieldDate.getText()));
			} catch (ParseException ex) {
				//TODO: warn user?
				Logger.getLogger(TransactionEditor.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void accountCreated(FinanceAccount newAccount) {
		updateAccountsCombo();
	}

	@Override
	public void accountUpdated(FinanceAccount updatedAccount) {
		updateAccountsCombo();
	}

	@Override
	public void accountsUpdated() {
		updateAccountsCombo();
	}

	@Override
	public void accountDeleted(FinanceAccount deletedAccount) {
		updateAccountsCombo();
	}
}
