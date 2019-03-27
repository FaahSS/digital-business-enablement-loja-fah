package br.com.fiap.window;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.ProdutoBOStub;
import br.com.fiap.loja.bo.ProdutoBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.ProdutoBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.ProdutoBOStub.ProdutoTO;

public class TelaWSRequester {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaWSRequester window = new TelaWSRequester();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(159, 26, 208, 20);
		lblNewLabel.setText("Digite o c\u00F3digo do produto");
		
		Label lblNewLabel2 = new Label(shell, SWT.NONE);
		lblNewLabel2.setBounds(136, 142, 257, 20);
		
		Button btnConfirmar = new Button(shell, SWT.NONE);
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int codigo = Integer.parseInt(text.getText());
				ProdutoBOStub stub = null;
				
				try {
					stub = new ProdutoBOStub();
				} catch (AxisFault e1) {
					// TODO Auto-generated catch block
					lblNewLabel2.setText("Produto não encontrado!");
				}
				
				ConsultarProduto consulta = new ConsultarProduto();
				consulta.setCodigo(codigo);
				ConsultarProdutoResponse response = null;
				try {
					response = stub.consultarProduto(consulta);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					lblNewLabel2.setText("Sistema fora do ar...");
				}
				
				ProdutoTO produto = response.get_return();
				lblNewLabel2.setText(produto.getDescricao());
			}
		});
		btnConfirmar.setBounds(207, 95, 90, 30);
		btnConfirmar.setText("Pesquisar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(162, 52, 186, 26);
		
		

	}
}
