package org.jeycode.zip4j;

import static java.lang.String.format;

import java.io.File;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;

@Slf4j(topic = "[Read-me]")
public class Zip4jSample
{

      private static final String PARENT_FILE = "C:\\Users\\JAVIER\\Desktop\\";
      private static final File FOLDER_SOURCE = new File(PARENT_FILE + "EClipse ACTIV\\GIT_REPOSITORY\\jeycode.cdp");
      private static final File FOLDER_TARGET_COMPRESS = new File(format("%szip-pruebas\\archiver.zip",PARENT_FILE));

      private static final char[] PASSWORD = "asdadareww7rg7s7rgn".toCharArray();
      private static ProgressMonitor progress;
      private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
      private static final ZipFile ZIP_FILE_OBJ = new ZipFile(FOLDER_TARGET_COMPRESS,PASSWORD);

      public static void main(String[] args) throws InterruptedException
      {
            if (compress())
            {
                  progress = ZIP_FILE_OBJ.getProgressMonitor();
                  scheduledThreadPoolExecutor.scheduleWithFixedDelay(log("comprimido"),0,500,TimeUnit.MILLISECONDS);
                  TimeUnit.SECONDS.sleep(20);
                  extractAll();
                  scheduledThreadPoolExecutor.scheduleWithFixedDelay(log("descomprimido"),0,500,TimeUnit.MILLISECONDS);
                  TimeUnit.SECONDS.sleep(20);
                  scheduledThreadPoolExecutor.shutdown();
            }
      }

      private static Runnable log(String str)
      {
            return ()->
                  {
                        int percentDone = progress.getPercentDone();
                        log.info("Se lleva {} un {}%",str,percentDone);
                        if (percentDone >= 100)
                        {
                              log.info("Se ha {} con éxito el directorio",str);
                              throw new RuntimeException();
                        }
                  };
      }

      private static boolean compress()
      {

            try
            {
                  var zipParameters = new ZipParameters();
                  zipParameters.setEncryptFiles(true);
                  zipParameters.setCompressionLevel(CompressionLevel.ULTRA);
                  zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
                  zipParameters.setEncryptionMethod(EncryptionMethod.AES);
                  zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
                  ZIP_FILE_OBJ.setRunInThread(true);
                  ZIP_FILE_OBJ.addFolder(FOLDER_SOURCE,zipParameters);
                  log.info("Se procede a comprimir");
                  return true;
            }
            catch (Exception ex)
            {
                  log.error("Error en la compresión",ex);
                  return false;

            }
      }

      private static boolean extractAll()
      {
            try
            {
                  ZIP_FILE_OBJ.extractAll(PARENT_FILE + "zip-pruebas");
                  log.info("Se procede a descomprimir");
                  return true;
            }
            catch (Exception ex)
            {
                  log.error("Error en la descompresión",ex);
                  return false;

            }
      }

}
