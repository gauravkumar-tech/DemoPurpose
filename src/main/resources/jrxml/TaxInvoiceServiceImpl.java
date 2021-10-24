package com.jilit.unity.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jilit.unity.model.CompanyLogo;
import com.jilit.unity.repository.CompanyLogoRepository;
import com.jilit.unity.repository.ProfitCentreMasterRepository;
import com.jilit.unity.service.TaxInvoiceService;
import com.jilit.unity.util.CommanUtils;

/**
 * @author gaurav.kumar
 *
 */
@Service
public class TaxInvoiceServiceImpl implements TaxInvoiceService{

	@Autowired
	ProfitCentreMasterRepository profitcentremasterrepository;
	
	@Autowired
	CompanyLogoRepository companylogorepository;
	
	@Override
	public void generateinvoice(HttpServletResponse response, Map jsonMap) {
		List <Map<Object,Object>> data = new ArrayList<>();
		Map<Object,Object> listMap = new HashMap<>();
		Map<String,Object> parameters= new HashMap<>();
		List invoiceList=(List) jsonMap.get("invoiceList");
		Map mapToSendMap= new HashMap();
//		mapToSendMap.put("invoiceList", invoiceList);
//		data.add(mapToSendMap);
		
		try {
			String profitcentreid= jsonMap.get("profitcentreid").toString();
			Map list = profitcentremasterrepository.getProfitCenterData(profitcentreid);

			String companyname = "";
			String profitcentrename = "";
			String profitcentrecityname = "";
			String profitcentrestatename = "";
			String profitcentrepin = "";
			
			if (!list.isEmpty()) {
				companyname = list.get("companyname") == null ? "" : list.get("companyname").toString();
				profitcentrename = list.get("profitcentrename") == null ? "" : list.get("profitcentrename").toString();
				profitcentrecityname = list.get("profitcentrecityname") == null ? ""
						: list.get("profitcentrecityname").toString();
				profitcentrestatename = list.get("profitcentrestatename") == null ? ""
						: list.get("profitcentrestatename").toString();
				profitcentrepin = list.get("profitcentrepin") == null ? "" : list.get("profitcentrepin").toString();

				parameters = new HashMap<String, Object>();
				String gstin="23AACJ6297K4Z6";
				CompanyLogo logo = companylogorepository.findById(list.get("companyid").toString()).orElse(null);
				parameters.put("logoimage", logo == null ? null : logo.getCompanylogo());
				parameters.put("companyname", companyname);
				parameters.put("profitcentrename", profitcentrename);
				parameters.put("gstin", "GSTIN:"+gstin);
				
				}
			
			
			List fakeInvoiceList= new ArrayList();
			List fakeInvoiceList1= new ArrayList();
			
			
			for(int t=0;t<2;t++) {
				Map map=new HashMap();
				Map map1=new HashMap();
				
				
				
				String irn="43798hfundcjksciah92977h3bhbjahbjsbhdbabkdab3";
				String invoiceno="212311005691"+t;
				String supplytype="B2B";
				String agreementdate="JUNE-2021";
				String invoicedate="10.05.2021";
				String documenttype="Invoice";
				String referenceno="NIGRIE POWER PLANT";
				String placeofsupply="Madhya Pradesh";
				String code="23";
				String reversecharge="No";
				String period="JUNE-2021";
				String whethersupplyisserviceornot="";
				String detailsOfServiceRecipient="";
				String name="SUMMIT DIGITEL INFRASTRUCTUE";
				String address="DB City Mall, Office Block No.01 BHOPAL-462016, Madhya Pradesh";
				String gstininvoice="23AAGCR2798R1ZJ";
				String state="Madhya Pradesh";
				
				
				map.put("irn", "IRN:"+irn);
				map.put("invoiceno", "Invoice No:"+invoiceno);
				map.put("supplytype", "Supply Type:"+supplytype);
				map.put("agreementdate", "Agreement Dated:"+agreementdate);
				map.put("invoicedate", "Invoice Date:"+invoicedate);
				map.put("documenttype", "Document Type:"+documenttype);
				map.put("referenceno", "Reference No:"+referenceno);
				map.put("reversecharge", "Reverso Charge:"+reversecharge);
				map.put("period", "Period:"+period);
				
				map.put("placeofsupply", "Place of Supply:"+placeofsupply);
				map.put("code", "Code:"+code);
				
				map.put("whethersupplyisserviceornot", "Whether Supply is Service or Not:"+whethersupplyisserviceornot);
				map.put("detailsOfServiceRecipient", "Details of Service Recipient:"+detailsOfServiceRecipient);
				map.put("name", "Name:"+name);
				map.put("address", "Address:"+address);
				map.put("gstinvoice", "GSTIN:"+gstininvoice);
				map.put("state", "State:"+state);
				
				
				map1.put("slno", "1");
				map1.put("servicedesc", "RENT: MONTH OF JUNE-21 (SITE:NIGRIE POWER PLANT)");
				map1.put("hsncode", "997212");
				map1.put("uon", "NOS");
				map1.put("qty", "5,500.00");
				map1.put("amount", "5,500.00");
				map1.put("taxable", "5,500.00");
				map1.put("cgstr", "9.00%");
				map1.put("cgsta", "495.00");
				map1.put("sgstr", "9.00%");
				map1.put("sgsta", "495");
				map1.put("igstr", "0.00%");
				map1.put("igsta", "0.00");
				map1.put("total", "6,490.00");
				fakeInvoiceList1.add(map1);
				
				map1= new HashMap();
				map1.put("slno", "2");
				map1.put("servicedesc", "RENT: MONTH OF JUNE-21 (SITE:NIGRIE POWER PLANT)");
				map1.put("hsncode", "997212");
				map1.put("uon", "NOS");
				map1.put("qty", "5,500.00");
				map1.put("amount", "5,500.00");
				map1.put("taxable", "5,500.00");
				map1.put("cgstr", "9.00%");
				map1.put("cgsta", "495.00");
				map1.put("sgstr", "9.00%");
				map1.put("sgsta", "495");
				map1.put("igstr", "0.00%");
				map1.put("igsta", "0.00");
				map1.put("total", "6,490.00");
				fakeInvoiceList1.add(map1);
				
				

				fakeInvoiceList.add(map);
				
				map.put("testlist", fakeInvoiceList1);
				
			}
			
		
			
			
			mapToSendMap.put("invoiceList", fakeInvoiceList);
//			mapToSendMap.put("testlist", );
			data.add(mapToSendMap);
			
			
//			for() {
//				CommanUtils.downloadJasperReport(data, "/jrxml/taxinvoiceg.jasper", parameters, response);
//			}
			CommanUtils.downloadJasperReport(data, "/jrxml/taxinvoiceg.jasper", parameters, response);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	
	
}
