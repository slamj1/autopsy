/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011-2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.directorytree;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.coreutils.Logger;

/**
 * An options panel for the user to create, edit, and delete associations for
 * opening files in external viewers. Users can associate a file by either MIME
 * type or by extension to an executable file.
 */
final class ExternalViewerGlobalSettingsPanel extends javax.swing.JPanel implements OptionsPanel {

    private static final Logger logger = Logger.getLogger(ExternalViewerGlobalSettingsPanel.class.getName());
    private DefaultListModel<ExternalViewerRule> rulesListModel;
    private java.util.List<ExternalViewerRule> rules;

    /**
     * Creates new form ExternalViewerGlobalSettingsPanel
     */
    public ExternalViewerGlobalSettingsPanel() {
        initComponents();
        customizeComponents();
    }

    /**
     * Initializes field variables. Adds a listener to the list of rules.
     */
    private void customizeComponents() {
        rulesListModel = new DefaultListModel<>();
        rules = new ArrayList<>();
        rulesList.setModel(rulesListModel);
        rulesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    if (rulesList.getSelectedIndex() == -1) {
                        clearExePath();
                    } else {
                        populateExePath();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        externalViewerTitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        exePanel = new javax.swing.JPanel();
        exePathLabel = new javax.swing.JLabel();
        exePathNameLabel = new javax.swing.JLabel();
        rulesPanel = new javax.swing.JPanel();
        ruleListLabel = new javax.swing.JLabel();
        rulesScrollPane = new javax.swing.JScrollPane();
        rulesList = new javax.swing.JList<>();
        newRuleButton = new javax.swing.JButton();
        editRuleButton = new javax.swing.JButton();
        deleteRuleButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(701, 453));

        jPanel1.setPreferredSize(new java.awt.Dimension(701, 453));

        org.openide.awt.Mnemonics.setLocalizedText(externalViewerTitleLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.externalViewerTitleLabel.text")); // NOI18N

        jSplitPane1.setDividerLocation(365);
        jSplitPane1.setDividerSize(1);

        exePanel.setPreferredSize(new java.awt.Dimension(311, 224));

        org.openide.awt.Mnemonics.setLocalizedText(exePathLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.exePathLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(exePathNameLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.exePathNameLabel.text")); // NOI18N

        javax.swing.GroupLayout exePanelLayout = new javax.swing.GroupLayout(exePanel);
        exePanel.setLayout(exePanelLayout);
        exePanelLayout.setHorizontalGroup(
            exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exePathLabel)
                    .addComponent(exePathNameLabel))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        exePanelLayout.setVerticalGroup(
            exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exePathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exePathNameLabel)
                .addContainerGap(361, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(exePanel);

        rulesPanel.setPreferredSize(new java.awt.Dimension(365, 406));

        org.openide.awt.Mnemonics.setLocalizedText(ruleListLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.ruleListLabel.text")); // NOI18N

        rulesScrollPane.setViewportView(rulesList);

        newRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/add16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(newRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.newRuleButton.text")); // NOI18N
        newRuleButton.setMaximumSize(new java.awt.Dimension(111, 25));
        newRuleButton.setMinimumSize(new java.awt.Dimension(111, 25));
        newRuleButton.setPreferredSize(new java.awt.Dimension(111, 25));
        newRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRuleButtonActionPerformed(evt);
            }
        });

        editRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/edit16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.editRuleButton.text")); // NOI18N
        editRuleButton.setMaximumSize(new java.awt.Dimension(111, 25));
        editRuleButton.setMinimumSize(new java.awt.Dimension(111, 25));
        editRuleButton.setPreferredSize(new java.awt.Dimension(111, 25));
        editRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRuleButtonActionPerformed(evt);
            }
        });

        deleteRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/delete16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.deleteRuleButton.text")); // NOI18N
        deleteRuleButton.setMaximumSize(new java.awt.Dimension(111, 25));
        deleteRuleButton.setMinimumSize(new java.awt.Dimension(111, 25));
        deleteRuleButton.setPreferredSize(new java.awt.Dimension(111, 25));
        deleteRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRuleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rulesPanelLayout = new javax.swing.GroupLayout(rulesPanel);
        rulesPanel.setLayout(rulesPanelLayout);
        rulesPanelLayout.setHorizontalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rulesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ruleListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rulesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        rulesPanelLayout.setVerticalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rulesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ruleListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rulesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteRuleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(rulesPanel);

        jScrollPane1.setViewportView(jSplitPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(externalViewerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(externalViewerTitleLabel)
                .addContainerGap(428, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRuleButtonActionPerformed
        AddExternalViewerRuleDialog dialog = new AddExternalViewerRuleDialog();
        AddExternalViewerRuleDialog.BUTTON_PRESSED result = dialog.getResult();
        if (result == AddExternalViewerRuleDialog.BUTTON_PRESSED.OK) {
            ExternalViewerRule newRule = dialog.getRule();
            // Only allow one association for each MIME type or extension.
            if (rules.contains(newRule)) {
                JOptionPane.showMessageDialog(this,
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.message"),
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.title"),
                        JOptionPane.ERROR_MESSAGE);
            } else {
                rules.add(newRule);
                updateRulesListModel();
                int index = rules.indexOf(newRule);
                rulesList.setSelectedIndex(index);
                enableButtons();
                firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
            }
        }
    }//GEN-LAST:event_newRuleButtonActionPerformed

    private void editRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRuleButtonActionPerformed
        int selected = rulesList.getSelectedIndex();
        AddExternalViewerRuleDialog dialog = new AddExternalViewerRuleDialog(rulesListModel.get(rulesList.getSelectedIndex()));
        AddExternalViewerRuleDialog.BUTTON_PRESSED result = dialog.getResult();
        if (result == AddExternalViewerRuleDialog.BUTTON_PRESSED.OK) {
            rules.remove(selected);
            ExternalViewerRule newRule = dialog.getRule();
            // Only allow one association for each MIME type or extension.
            if (rules.contains(newRule)) {
                JOptionPane.showMessageDialog(this,
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.message"),
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.title"),
                        JOptionPane.ERROR_MESSAGE);
            } else {
                rules.add(selected, dialog.getRule());
                updateRulesListModel();
                firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
            }
        }
        rulesList.setSelectedIndex(selected);
        enableButtons();
    }//GEN-LAST:event_editRuleButtonActionPerformed

    private void deleteRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRuleButtonActionPerformed
        ExternalViewerRule rule = rulesList.getSelectedValue();
        rules.remove(rule);
        updateRulesListModel();
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_deleteRuleButtonActionPerformed

    @Override
    public void store() {
        ExternalViewerRulesManager.getInstance().setUserRules(rules);
    }

    @Override
    public void load() {
        rules = ExternalViewerRulesManager.getInstance().getUserRules();
        updateRulesListModel();
        enableButtons();
    }

    /**
     * Enable edit and delete buttons if there is a rule selected.
     */
    private void enableButtons() {
        boolean ruleIsSelected = rulesList.getSelectedIndex() != -1;
        editRuleButton.setEnabled(ruleIsSelected);
        deleteRuleButton.setEnabled(ruleIsSelected);
    }

    /**
     * Sets the list model for the rules list component, sorted by the MIME
     * type or extension alphabetically.
     */
    private void updateRulesListModel() {
        rulesListModel.clear();
        Collections.sort(rules);
        for (ExternalViewerRule rule : rules) {
            rulesListModel.addElement(rule);
        }
    }

    /**
     * Fills in the .exe file path label if a rule is selected.
     */
    private void populateExePath() {
        ExternalViewerRule rule = rulesList.getSelectedValue();
        if (rule != null) {
            if (rule.getRuleType() == ExternalViewerRule.RuleType.MIME) {
                exePathLabel.setText(NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class,
                        "ExternalViewerGlobalSettingsPanel.exePathLabel.MIME.text"));
            } else {
                exePathLabel.setText(NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class,
                        "ExternalViewerGlobalSettingsPanel.exePathLabel.EXT.text"));
            }
            exePathNameLabel.setText(rule.getExePath());
        }
        enableButtons();
    }

    /**
     * Clears the .exe file path label.
     */
    private void clearExePath() {
        rulesList.clearSelection();
        exePathLabel.setText(NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class,
                "ExternalViewerGlobalSettingsPanel.exePathLabel.text"));
        exePathNameLabel.setText(NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class,
                "ExternalViewerGlobalSettingsPanel.exePathLabel.empty.text"));
        enableButtons();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteRuleButton;
    private javax.swing.JButton editRuleButton;
    private javax.swing.JPanel exePanel;
    private javax.swing.JLabel exePathLabel;
    private javax.swing.JLabel exePathNameLabel;
    private javax.swing.JLabel externalViewerTitleLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton newRuleButton;
    private javax.swing.JLabel ruleListLabel;
    private javax.swing.JList<ExternalViewerRule> rulesList;
    private javax.swing.JPanel rulesPanel;
    private javax.swing.JScrollPane rulesScrollPane;
    // End of variables declaration//GEN-END:variables
}
