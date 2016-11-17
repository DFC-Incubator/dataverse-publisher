/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.de.dvpublisher;

import com.researchspace.dataverse.api.v1.DataverseAPI;
import com.researchspace.dataverse.api.v1.DataverseConfig;
import com.researchspace.dataverse.http.DataverseAPIImpl;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * The entry (wrapping) class to the Dataverse-client-Java API
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DataverseClient {

    private static final Logger logger = Logger.getLogger(DataverseClient.class.getName());

    private DataverseAPI apiClient = new DataverseAPIImpl();

    private DataverseConfig config;


    public DataverseClient(String dataverseServer, String apikey,
            String dataverseAlias) throws MalformedURLException {
        this.config = new DataverseConfig(new URL(dataverseServer),
                apikey, dataverseAlias);
        apiClient.configure(config);
    }

    public void publishDatafile(String persistentId, File file) {

        if (StringUtils.isBlank(persistentId)) {
            throw new IllegalArgumentException("persistentId should not be blank");
        } else if (persistentId.startsWith("doi:")){
            persistentId = persistentId.replace("doi:", "");
        }

        if (!file.exists() || file.length() == 0L) {
            throw new IllegalArgumentException("A target file must exit and be non-empty");
        }

        logger.log(Level.INFO, "persistentId={0}", persistentId);
        apiClient.getDatasetOperations().uploadFile(persistentId, file);

    }

    public void publishDatafile(String persistentId, String filename) {
        File file = new File(filename);
        publishDatafile(persistentId, file);
    }

}
