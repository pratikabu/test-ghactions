/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sf.jsharing.components;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

import net.sf.jsharing.boundary.UploadFormPanel;

/**
 * 
 * @author Pratik
 */
public class FileTransferHandler extends TransferHandler {

	private DataFlavor fileFlavor;
	private UploadFormPanel uploadForm;

	public FileTransferHandler(UploadFormPanel uploadForm) {
		this.uploadForm = uploadForm;
		fileFlavor = DataFlavor.javaFileListFlavor;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean importData(JComponent c, Transferable t) {
		if (!canImport(c, t.getTransferDataFlavors())) {
			return false;
		}

		try {
			if (hasFileFlavor(t.getTransferDataFlavors())) {
				List files = (List) t.getTransferData(fileFlavor);
				uploadForm.addFiles(files);
				return true;
			}
		} catch (UnsupportedFlavorException ufe) {
			System.out.println("importData: unsupported data flavor");
		} catch (IOException ieo) {
			System.out.println("importData: I/O exception");
		}
		return false;
	}

	@Override
	public int getSourceActions(JComponent c) {
		return COPY_OR_MOVE;
	}

	@Override
	public boolean canImport(JComponent c, DataFlavor[] flavors) {
		if (hasFileFlavor(flavors)) {
			return true;
		}
		return false;
	}

	private boolean hasFileFlavor(DataFlavor[] flavors) {
		for (int i = 0; i < flavors.length; i++) {
			if (fileFlavor.equals(flavors[i])) {
				return true;
			}
		}
		return false;
	}
}
