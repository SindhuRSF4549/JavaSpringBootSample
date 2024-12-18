package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import com.syncfusion.licensing.SyncfusionLicenseProvider;
import com.syncfusion.docio.*;

@SpringBootApplication
public class DemoApplication {

	@Value("${app.key}")
    private static String licKey;

    public static void main(String[] args) throws Exception {
    
		SyncfusionLicenseProvider.registerLicense("GTIlMmhhZH1ifWdraGBifGJhfGpqampzYWBpZmppZmpoJTY9ODoTMTwrNTo/Nn06PQ==");

    	try (//Creates an instance of WordDocument Instance (Empty Word Document).
    		WordDocument document = new WordDocument()) {
			document.ensureMinimal();
			//Append text to the last paragraph of the document.
			document.getLastParagraph().appendText("Hello World");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			document.save(byteArrayOutputStream, FormatType.Txt);
			// Read text from ByteArrayOutputStream
			String textFromStream = readTextFromStream(byteArrayOutputStream);
			// Print the extracted text
			System.out.println("Text read from ByteArrayOutputStream:");
			System.out.println(textFromStream);
		}
		System.out.print("Completed");
		SpringApplication.run(DemoApplication.class, args);
	}
  //Helper method to read text from ByteArrayOutputStream
  	private static String readTextFromStream(ByteArrayOutputStream byteArrayOutputStream) {
  	    // Convert the byte array to a String
  	    return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
  	}
}
