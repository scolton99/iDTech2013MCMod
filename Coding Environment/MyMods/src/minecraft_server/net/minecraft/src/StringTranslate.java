package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.IllegalFormatException;
import java.util.Properties;
import java.util.TreeMap;

public class StringTranslate
{
    /** Is the private singleton instance of StringTranslate. */
    private static StringTranslate instance = new StringTranslate("en_US");

    /**
     * Contains all key/value pairs to be translated - is loaded from '/lang/en_US.lang' when the StringTranslate is
     * created.
     */
    private Properties translateTable = new Properties();
    private TreeMap languageList;
    private TreeMap field_94521_d = new TreeMap();
    private String currentLanguage;
    private boolean isUnicode;

    public StringTranslate(String par1Str)
    {
        this.loadLanguageList();
        this.setLanguage(par1Str, false);
    }

    /**
     * Return the StringTranslate singleton instance
     */
    public static StringTranslate getInstance()
    {
        return instance;
    }

    private void loadLanguageList()
    {
        TreeMap var1 = new TreeMap();

        try
        {
            BufferedReader var2 = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/languages.txt"), "UTF-8"));

            for (String var3 = var2.readLine(); var3 != null; var3 = var2.readLine())
            {
                String[] var4 = var3.trim().split("=");

                if (var4 != null && var4.length == 2)
                {
                    var1.put(var4[0], var4[1]);
                }
            }
        }
        catch (IOException var5)
        {
            var5.printStackTrace();
            return;
        }

        this.languageList = var1;
        this.languageList.put("en_US", "English (US)");
    }

    public TreeMap getLanguageList()
    {
        return this.languageList;
    }

    private void loadLanguage(Properties par1Properties, String par2Str) throws IOException
    {
        BufferedReader var3 = null;

        if (this.field_94521_d.containsKey(par2Str))
        {
            var3 = new BufferedReader(new FileReader((File)this.field_94521_d.get(par2Str)));
        }
        else
        {
            var3 = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/" + par2Str + ".lang"), "UTF-8"));
        }

        for (String var4 = var3.readLine(); var4 != null; var4 = var3.readLine())
        {
            var4 = var4.trim();

            if (!var4.startsWith("#"))
            {
                String[] var5 = var4.split("=");

                if (var5 != null && var5.length == 2)
                {
                    par1Properties.setProperty(var5[0], var5[1]);
                }
            }
        }
    }

    public synchronized void setLanguage(String par1Str, boolean par2)
    {
        if (par2 || !par1Str.equals(this.currentLanguage))
        {
            Properties var3 = new Properties();

            try
            {
                this.loadLanguage(var3, "en_US");
            }
            catch (IOException var9)
            {
                ;
            }

            this.isUnicode = false;

            if (!"en_US".equals(par1Str))
            {
                try
                {
                    this.loadLanguage(var3, par1Str);
                    Enumeration var4 = var3.propertyNames();

                    while (var4.hasMoreElements() && !this.isUnicode)
                    {
                        Object var5 = var4.nextElement();
                        Object var6 = var3.get(var5);

                        if (var6 != null)
                        {
                            String var7 = var6.toString();

                            for (int var8 = 0; var8 < var7.length(); ++var8)
                            {
                                if (var7.charAt(var8) >= 256)
                                {
                                    this.isUnicode = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                catch (IOException var10)
                {
                    var10.printStackTrace();
                    return;
                }
            }

            this.currentLanguage = par1Str;
            this.translateTable = var3;
        }
    }

    /**
     * Translate a key to current language.
     */
    public synchronized String translateKey(String par1Str)
    {
        return this.translateTable.getProperty(par1Str, par1Str);
    }

    /**
     * Translate a key to current language applying String.format()
     */
    public synchronized String translateKeyFormat(String par1Str, Object ... par2ArrayOfObj)
    {
        String var3 = this.translateTable.getProperty(par1Str, par1Str);

        try
        {
            return String.format(var3, par2ArrayOfObj);
        }
        catch (IllegalFormatException var5)
        {
            return "Format error: " + var3;
        }
    }

    /**
     * Returns true if the passed key is in the translation table.
     */
    public synchronized boolean isKeyTranslated(String par1Str)
    {
        return this.translateTable.containsKey(par1Str);
    }

    /**
     * Translate a key with a extra '.name' at end added, is used by blocks and items.
     */
    public synchronized String translateNamedKey(String par1Str)
    {
        return this.translateTable.getProperty(par1Str + ".name", "");
    }
}
