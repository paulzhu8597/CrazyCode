# coding=utf-8
from _overlapped import NULL
import codecs  
import os    
import re            
import shutil
import sys  
import time            
import urllib

from bs4 import BeautifulSoup
from selenium import webdriver        
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys        

import selenium.webdriver.support.ui as ui    

options = webdriver.ChromeOptions()
options.add_experimental_option("excludeSwitches", ["ignore-certificate-errors"])
options.add_argument("--user-data-dir="+r"C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/")

driver = webdriver.Chrome(chrome_options=options)

#欧洲航天局 欧空局公布包含10亿颗恒星的三维星图 文件下载爬虫


class GaiaSourceSpider:
    
    @classmethod
    def GaiaSourceData(cls):
        for i in range(0,110):
            driver.get("http://cdn.gea.esac.esa.int/Gaia/gaia_source/csv/GaiaSource_000-000-00"+str(i)+".csv.gz")
            time.sleep(35)

GaiaSourceSpider.GaiaSourceData()            