package presenter;

import java.util.Formatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import model.Pizza;
import settings.Settings;
import view.CartFrame;
import view.DeinePizzaFrame;

/**
 * Diese Klasse repr�sentiert den Presenter f�r DeinePizzaFrame
 * Im Presenter werden den Komponenten Funktionen hinzugewiesen und die View geupdatet.
 * 
 * @author Sean, Kevin, Daniyal, Farid, Sven
 * @see DeinePizzaFrame
 * @see CartFrame
 * @see Pizza
 * @see JOptionPane
 * @see Settings
 * @see Formatter
 * @see Double
 */
public class DeinePizzaPresenter {

	DeinePizzaFrame deinePizzaFrame = new DeinePizzaFrame();
	CartFrame cartFrame = new CartFrame();
	Pizza pizza = new Pizza();
	double currentPaprika=0.00;
	double currentCorn=0.00;
	double currentBacon=0.00;
	double currentSalami=0.00;
	double currentSucuk=0.00;
	double currentOnion=0.00;
	double currentBroccoli=0.00;
	double currentHam=0.00;
	double pizzaPrice=0.00;
	double gesamtpreis=0.00;
	double checkPaprika = 0;
	double checkCorn = 0;
	double checkBacon = 0;
	double checkSalami = 0;
	double checkSucuk = 0;
	double checkOnion = 0;
	double checkBroccoli = 0;
	double checkHam = 0;
	double totalPrice;
	
	/**
	 * �ffnet das DeinePizzaFrame und aktiviert die Funktionen der GUI-Elemente sowie die allgemeine Logik.
	 */
	@SuppressWarnings("resource")
	public DeinePizzaPresenter() {
		deinePizzaFrame.setVisible(true);
		
		
		// ###DeinePizza Listener###
		//Listener den generellen Buttons hinzugef�gt
		deinePizzaFrame.getBackButton().addActionListener(e -> {
			new MainFramePresenter();
			deinePizzaFrame.setVisible(false);
		});
		
		deinePizzaFrame.getCartButton().addActionListener(e -> {
			new CartPresenter();
			deinePizzaFrame.setVisible(false);
		});
		
		deinePizzaFrame.getAddButton().addActionListener(e -> {
			
			if(deinePizzaFrame.getSmallRadioButton().isSelected() || deinePizzaFrame.getMediumRadioButton().isSelected() || deinePizzaFrame.getLargeRadioButton().isSelected() || deinePizzaFrame.getExtraLargeRadioButton().isSelected()) {
				
				JOptionPane.showMessageDialog(null,"Die Bestellung wurde dem Warenkorb hinzugef�gt");
				totalPrice += gesamtpreis;
				System.out.println(totalPrice);
				
				pizza.setName(gesamtpreis);
				cartFrame.setCartList(Pizza.getName());
				pizza.setReset();
				
				
				Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
				Settings.cartPriceLabel.setText(formatter.format("%.2f", totalPrice).toString());
			}
			else {
				JOptionPane.showMessageDialog(null, "Bitte w�hle eine Gr��e!");
			}
		});
		
		
		
		//Listener den sizeRadioButtons[] hinzugef�gt
		deinePizzaFrame.getSmallRadioButton().addItemListener(e -> {
			deinePizzaFrame.getBottomValueLabel().setText("0.00");
			pizzaPrice = 4.50;
			changeDeinePizzaPrice();
		});
		
		deinePizzaFrame.getMediumRadioButton().addItemListener(e -> {
			deinePizzaFrame.getBottomValueLabel().setText("0.00");
			pizzaPrice = 5.70;
			changeDeinePizzaPrice();
		});
		
		deinePizzaFrame.getLargeRadioButton().addItemListener(e -> {
			deinePizzaFrame.getBottomValueLabel().setText("0.00");
			pizzaPrice = 6.90;
			changeDeinePizzaPrice();
		});
		
		deinePizzaFrame.getExtraLargeRadioButton().addItemListener(e -> {
			deinePizzaFrame.getBottomValueLabel().setText("0.00");
			pizzaPrice = 8.10;
			changeDeinePizzaPrice();
		});
		
				
				
		//Listener den JSpinnern hinzuf�gen
		deinePizzaFrame.getPaprikaSpinner().addChangeListener(e -> {
			double value = Double.valueOf(deinePizzaFrame.getPaprikaSpinner().getValue().toString()).intValue();
			

			checkPaprika ++;
			if (checkPaprika == value) {
				if(value == 0){
					currentPaprika=0.00;
				}
				else if(value==1) {
					currentPaprika += 0.20;
				}
				else if (value == 2){
					currentPaprika += 0.20;
				}
				else if (value == 3) {
					currentPaprika += 0.20;
				}
				changeDeinePizzaPrice();
			}
			else {
				if(value == 0){
					currentPaprika=0.00;
				}
				else {
					currentPaprika -= 0.20;
				}
				checkPaprika = value;
				changeDeinePizzaPrice();
			}
		});
		
				//BaconSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getBaconSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getBaconSpinner().getValue().toString()).intValue();
					
					
					checkBacon ++;
					if (checkBacon == value) {
						if(value == 0){
							currentBacon=0.00;
						}
						else if(value==1) {
							currentBacon += 0.60;
						}
						else if (value == 2){
							currentBacon += 0.60;
						}
						else if (value == 3) {
							currentBacon += 0.60;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentBacon=0.00;
						}
						else {
							currentBacon -= 0.60;
						}
						checkBacon = value;
						changeDeinePizzaPrice();
					}
				});
				
				//CornSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getCornSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getCornSpinner().getValue().toString()).intValue();
					
					
					checkCorn ++;
					if (checkCorn == value) {
						if(value == 0){
							currentCorn=0.00;
						}
						else if(value==1) {
							currentCorn += 0.15;
						}
						else if (value == 2){
							currentCorn += 0.15;
						}
						else if (value == 3) {
							currentCorn += 0.15;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentCorn=0.00;
						}
						else {
							currentCorn -= 0.15;
						}
						checkCorn = value;
						changeDeinePizzaPrice();
					}
				});
				
				//SalamiSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getSalamiSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getSalamiSpinner().getValue().toString()).intValue();
							
					checkSalami ++;
					if (checkSalami == value) {
						if(value == 0){
							currentSalami=0.00;
						}
						else if(value==1) {
							currentSalami += 0.70;
						}
						else if (value == 2){
							currentSalami += 0.70;
						}
						else if (value == 3) {
							currentSalami += 0.70;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentSalami=0.00;
						}
						else {
							currentSalami -= 0.70;
						}
						checkSalami = value;
						changeDeinePizzaPrice();
					}
				});
				
				//SucukSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getSucukSpinner().addChangeListener(e -> {	
					double value = Double.valueOf(deinePizzaFrame.getSucukSpinner().getValue().toString()).intValue();
									
					checkSucuk ++;
					if (checkSucuk == value) {
						if(value == 0){
							currentSucuk=0.00;
						}
						else if(value==1) {
							currentSucuk += 1.00;
						}
						else if (value == 2){
							currentSucuk += 1.00;
						}
						else if (value == 3) {
							currentSucuk += 1.00;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentSucuk=0.00;
						}
						else {
							currentSucuk -= 1.00;
						}
						checkSucuk = value;
						changeDeinePizzaPrice();
					}
				});
				
				//OnionSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getOnionSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getOnionSpinner().getValue().toString()).intValue();
					
					checkOnion ++;
					if (checkOnion == value) {
						if(value == 0){
							currentOnion=0.00;
						}
						else if(value==1) {
							currentOnion += 0.20;
						}
						else if (value == 2){
							currentOnion += 0.20;
						}
						else if (value == 3) {
							currentOnion += 0.20;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentOnion=0.00;
						}
						else {
							currentOnion -= 0.20;
						}
						checkOnion = value;
						changeDeinePizzaPrice();
					}

				});
				
				//BroccoliSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getBroccoliSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getBroccoliSpinner().getValue().toString()).intValue();
					
					checkBroccoli ++;
						if (checkBroccoli == value) {
							if(value == 0){
								currentBroccoli=0.00;
							}
							else if(value==1) {
								currentBroccoli += 0.40;
							}
							else if (value == 2){
								currentBroccoli += 0.40;
							}
							else if (value == 3) {
								currentBroccoli += 0.40;
							}
							changeDeinePizzaPrice();
						}
						else {
							if(value == 0){
								currentBroccoli=0.00;
							}
							else {
								currentBroccoli -= 0.40;
							}
							checkBroccoli = value;
							changeDeinePizzaPrice();
						}
						
					});
				
				//HamSpinner ein ChangeListener hinzuf�gen
				deinePizzaFrame.getHamSpinner().addChangeListener(e -> {
					double value = Double.valueOf(deinePizzaFrame.getHamSpinner().getValue().toString()).intValue();
					
					checkHam ++;
					if (checkHam == value) {
						if(value == 0){
							currentHam=0.00;
						}
						else if(value==1) {
							currentHam += 0.80;
						}
						else if (value == 2){
							currentHam += 0.80;
						}
						else if (value == 3) {
							currentHam += 0.80;
						}
						changeDeinePizzaPrice();
					}
					else {
						if(value == 0){
							currentHam=0.00;
						}
						else {
							currentHam -= 0.80;
						}
						checkHam = value;
						changeDeinePizzaPrice();
					}
					
				});
	}
	
	
	/**
	 *  Bei einer Pizzabestellung wird der Warenkorb Wert ver�ndert
	 *  Aufaddieren des Warenkorb-Wertes
	 *  
	 */
	@SuppressWarnings("resource")
	public void changeDeinePizzaPrice () {
		double currentPrice=0.00;
		
		currentPrice = currentBacon + currentPaprika + currentCorn + currentSalami + currentSucuk + currentOnion + currentBroccoli + currentHam;
		
		if(currentPrice == 0.00) {
			gesamtpreis = pizzaPrice;
			deinePizzaFrame.getBottomValueLabel().setText(String.valueOf(gesamtpreis));
		}
		else {
			gesamtpreis = Double.parseDouble(deinePizzaFrame.getBottomValueLabel().getText()); // Bekommt aktuellen Wert aus dem Warenkorb
			gesamtpreis = currentPrice+pizzaPrice;
	        Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
			deinePizzaFrame.getBottomValueLabel().setText(formatter.format("%.2f", gesamtpreis).toString());
			 
			totalPrice = Double.parseDouble(Settings.cartPriceLabel.getText()); 
		}
	}
}
