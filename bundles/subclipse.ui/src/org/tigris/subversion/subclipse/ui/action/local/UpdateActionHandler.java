package org.tigris.subversion.subclipse.ui.action.local;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler2;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.team.core.TeamException;
import org.eclipse.ui.PlatformUI;
import org.tigris.subversion.subclipse.ui.actions.UpdateAction;

public class UpdateActionHandler extends UpdateAction implements IHandler2 {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("Update...");
		try {
			super.execute(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	public boolean isEnabled() {
		try {
			selectionChanged(null, getCurrentSelection());
			return super.isEnabled();
		} catch (TeamException e) {
			return false;
		}
	}

	public boolean isHandled() {
		return true;
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

	public void setEnabled(Object evaluationContext) {
	}

	protected ISelection getCurrentSelection() {
		try {
			ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
					.getSelection();
			return selection;
		} catch (Exception e) {
		}
		return null;
	}

}