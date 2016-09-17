# coding=UTF-8
class ReadFile:
    
    @classmethod
    def getOneLine(cls,lineNum):    
        file = open("qqlist.txt")
        ilineNum = 0
        returnline = ""
        while 1:
            line = file.readline()
            if not line:
                break
            else:
                ilineNum = ilineNum + 1
                if ilineNum == lineNum:
                    returnline  = line
                    break
        return  returnline
    
    @classmethod
    def getFileLength(cls):
        return len(open("qqlist.txt",'rU').readlines())
    
    @classmethod
    def getCycleQQList(cls):    
        file = open("qqlist.txt")
        returnline = ""
        while 1:
            line = file.readline()
            if not line:
                break
            else:
                returnline  = line
                
    
    @classmethod
    def writeQQListFile(cls,istr):
        file = open("qqlist.txt","a")
        file.write(str(istr))
        file.write("\n")
        
    @classmethod
    def writeAllQqUsersInfo(cls,istr):
        file = open("allQqUsersInfo.txt","a")
        try:
            file.write(istr)
        except:
            file.write(str(istr.encode(encoding='utf_8', errors='strict')))    
        file.write("\n")
        
    @classmethod
    def writeQQListIndex(cls,istr):
        file = open("Index.txt","w")
        file.write(str(istr))
        
#print (ReadFile.getFileLength())
# ReadFile.writeFile("yyyyyyy")
# ReadFile.writeFile("uuuuuuuuu")

    @classmethod
    def test(cls):
        index  =1
        while index<=100:
            ReadFile.getOneLine(index)
            ReadFile.writeQQListFile(index)
            length = ReadFile.getFileLength()
            index = index+1
            print (str(length))
#ReadFile.test()           