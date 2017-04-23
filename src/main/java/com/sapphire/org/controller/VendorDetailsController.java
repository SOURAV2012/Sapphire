package com.sapphire.org.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.GlobalConstants;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.fxutils.BasicFxUtils;
import com.sapphire.org.fxutils.ControlAttr;
import com.sapphire.org.model.Vendor;
import com.sapphire.org.service.VendorService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

@Controller
public class VendorDetailsController extends AbstractController {

	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private VendorLayoutController vendorLayoutController; 

	@FXML
	private Label _vendorDetHeaderLabel;

	@FXML
	private GridPane _vendorDetTable;

	@FXML
	private TextField _vendorName;

	@FXML
	private TextField _vendorAddress;

	@FXML
	private TextField _vendorState;

	@FXML
	private TextField _vendorCity;

	@FXML
	private TextField _vendorPin;

	@FXML
	private TextField _vendorPhone;

	@FXML
	private TextArea _vendorComments;

	@FXML
	private Label _vendorNameLabel;

	@FXML
	private Label _vendorAddressLabel;

	@FXML
	private Label _vendorStateLabel;

	@FXML
	private Label _vendorCityLabel;

	@FXML
	private Label _vendorPinLabel;

	@FXML
	private Label _vendorPhoneLabel;
	
	@FXML
	private Label _vendorCommentLabel;
	
	@FXML
	private ToolBar _vendorLayoutToolbar;

	private AnchorPane vendorDetails;
	
	private Button _savehBtn;

	public VendorDetailsController() {
	}

	@FXML
	private void initialize() {		
		vendorDetails = (AnchorPane) getParentNode();
		completeLayout();
	}

	public Node getVendorDetailsDisplayView(Vendor vendor) {

		_vendorName.setVisible(false);
		_vendorAddress.setVisible(false);
		_vendorState.setVisible(false);
		_vendorCity.setVisible(false);
		_vendorPin.setVisible(false);
		_vendorPhone.setVisible(false);
		_vendorComments.setVisible(false);
		
		
		
		_vendorNameLabel.setVisible(true);
		_vendorAddressLabel.setVisible(true);
		_vendorStateLabel.setVisible(true);
		_vendorCityLabel.setVisible(true);
		_vendorPinLabel.setVisible(true);
		_vendorPhoneLabel.setVisible(true);
		_vendorCommentLabel.setVisible(true);
		
		_vendorNameLabel.setText(vendor.getVname());
		_vendorAddressLabel.setText(vendor.getVaddress());
		_vendorStateLabel.setText(vendor.getVstate());
		_vendorCityLabel.setText(vendor.getVcity());
		_vendorPinLabel.setText(vendor.getVpostalCode());
		_vendorPhoneLabel.setText(vendor.getVphone());
		_vendorCommentLabel.setText(vendor.getVcomments());
		
		//Disable save button
		_savehBtn.setDisable(true);
		
		//Set Vendor Label
		_vendorDetHeaderLabel.setText("Vendor Details ....");

		return vendorDetails;
	}
	
	@FXML
	public Node getVendorDetailsEditView() {

		_vendorName.setVisible(true);
		_vendorAddress.setVisible(true);
		_vendorState.setVisible(true);
		_vendorCity.setVisible(true);
		_vendorPin.setVisible(true);
		_vendorPhone.setVisible(true);
		_vendorComments.setVisible(true);

		_vendorNameLabel.setVisible(false);
		_vendorAddressLabel.setVisible(false);
		_vendorStateLabel.setVisible(false);
		_vendorCityLabel.setVisible(false);
		_vendorPinLabel.setVisible(false);
		_vendorPhoneLabel.setVisible(false);
		_vendorCommentLabel.setVisible(false);
		
		_vendorName.setText(GlobalConstants.BLANK);
		_vendorAddress.setText(GlobalConstants.BLANK);
		_vendorState.setText(GlobalConstants.BLANK);								
		_vendorPin.setText(GlobalConstants.BLANK);
		_vendorCity.setText(GlobalConstants.BLANK);
		_vendorPhone.setText(GlobalConstants.BLANK);
		_vendorComments.setText(GlobalConstants.BLANK);	
		
		//Enable save button
		_savehBtn.setDisable(false);
		
		//Set Vendor Label;
		_vendorDetHeaderLabel.setText("Add New Vendors.......");
		return vendorDetails;
	}
	
	
	@FXML
	private void saveVendorDetails(ActionEvent event){
		
		System.out.println("Called Vendor Save");
		
		Vendor _vendor = new Vendor(_vendorName.getText(),
									_vendorAddress.getText(),
									_vendorState.getText(),									
									_vendorPin.getText(),
									_vendorCity.getText(),
									_vendorPhone.getText(),
									_vendorComments.getText()				
								  );
		Vendor _savedVendor = vendorService.saveVendor(_vendor);		
		getVendorDetailsDisplayView(_savedVendor);
		vendorLayoutController.displayVendorList();
		
	}

	@Override
	public Node loadView() throws IOException {
		return viewFactory.load(ViewPath.VIEW_DETAILS);
	}

	@Override
	protected void completeLayout() {
		// TODO Auto-generated method stub
		
		_savehBtn = (Button) BasicFxUtils.getSaveButton(new ControlAttr("SAVE",100d,50d));
		_savehBtn.setPadding(new Insets(0, 10, 0, 0));
		_savehBtn.setOnAction(this::saveVendorDetails);
		_vendorLayoutToolbar.getItems().add(_savehBtn);
		
	}

}
