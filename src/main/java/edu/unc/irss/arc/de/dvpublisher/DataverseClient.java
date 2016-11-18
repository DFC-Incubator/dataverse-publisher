/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.de.dvpublisher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.researchspace.dataverse.api.v1.DataverseAPI;
import com.researchspace.dataverse.api.v1.DataverseConfig;
import com.researchspace.dataverse.http.DataverseAPIImpl;

/**
 * The entry (wrapping) class to the Dataverse-client-Java API
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DataverseClient {

	private static final Logger logger = Logger.getLogger(DataverseClient.class
			.getName());

	private DataverseAPI apiClient = new DataverseAPIImpl();

	private DataverseConfig config;

	public DataverseClient(String dataverseServer, String apikey,
			String dataverseAlias) throws MalformedURLException {
		this.config = new DataverseConfig(new URL(dataverseServer), apikey,
				dataverseAlias);
		apiClient.configure(config);
	}

	public void publishDatafile(String persistentId, File file) {

		if (StringUtils.isBlank(persistentId)) {
			throw new IllegalArgumentException(
					"persistentId should not be blank");
		} else if (persistentId.startsWith("doi:")) {
			persistentId = persistentId.replace("doi:", "");
		}

		if (!file.exists() || file.length() == 0L) {
			throw new IllegalArgumentException(
					"A target file must exit and be non-empty");
		}

		logger.log(Level.INFO, "persistentId={0}", persistentId);
		apiClient.getDatasetOperations().uploadFile(persistentId, file);

	}

	public void publishDatafile(String persistentId, String filename) {
		File file = new File(filename);
		publishDatafile(persistentId, file);
	}

	public static void main(String[] args) throws MalformedURLException {
		if (args.length != 5) {
			logger.log(
					Level.SEVERE,
					"Three arguments: dataverse_URL, Api_key, dataverse_Alias are expected dataset_Id file_location");
			throw new IllegalArgumentException(
					"The number of arguments must be 5.");
		}

		for (String arg : args) {
			logger.log(Level.INFO, "arg={0}", arg);
		}

		if (StringUtils.isBlank(args[0])) {
			logger.log(Level.SEVERE, "dataverse URL should not be blank");
			throw new IllegalArgumentException(
					"dataverse URL should not be blank");
		}

		if (StringUtils.isBlank(args[1])) {
			logger.log(Level.SEVERE, "API key should not be blank");
			throw new IllegalArgumentException("API Key should not be blank");
		}

		if (StringUtils.isBlank(args[2])) {
			logger.log(Level.SEVERE, "dataverse alias should not be blank");
			throw new IllegalArgumentException(
					"dataverse alias should not be blank");
		}

		if (StringUtils.isBlank(args[3])) {
			logger.log(Level.SEVERE, "dataset Id should not be blank");
			throw new IllegalArgumentException("dataset Id should not be blank");
		}

		if (StringUtils.isBlank(args[4])) {
			logger.log(Level.SEVERE, "file location should not be blank");
			throw new IllegalArgumentException(
					"file location should not be blank");
		}

		logger.log(Level.INFO, "running main method");
		logger.log(Level.INFO, "dataverseUrl:{0}", args[0]);
		logger.log(Level.INFO, "apiKey:{0}", args[1]);
		logger.log(Level.INFO, "dataverseAlias:{0}", args[2]);
		logger.log(Level.INFO, "datasetId:{0}", args[3]);
		logger.log(Level.INFO, "fileLocation:{0}", args[4]);

		DataverseClient dvClient = new DataverseClient(args[0], args[1],
				args[2]);

		logger.log(Level.INFO, "uploading a file to a target dataverse");
		dvClient.publishDatafile(args[3], args[4]);
		logger.log(Level.INFO, "uploading has been finished");
	}
}
