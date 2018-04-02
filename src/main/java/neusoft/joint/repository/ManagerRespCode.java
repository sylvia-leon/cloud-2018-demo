package neusoft.joint.repository;

import neusoft.ihrss.cloud.nt.exception.BusiException;
import neusoft.ihrss.cloud.nt.exception.TracedException;
import neusoft.joint.busi.common.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import telstar.core.tool.CVar;

/**
 * Created by leon on 2017/6/29.
 */
@Component
public class ManagerRespCode {

    private static final String SERVICE_M10101 = "m10101";
    private static final String SERVICE_M20101 = "m20101";
    private static final String SERVICE_M20102 = "m20102";

    private static final Logger logger = LoggerFactory.getLogger(ManagerRespCode.class);

    public void exChangeResCode(String serviceName, ResultDTO result) throws Exception{

        if(result.getResCode().equals(CVar.FAILED)){
            switch (serviceName){
                case SERVICE_M10101:
                    switch(result.getErrorCode()){
                        case 2004:
                            result.setErrorCode(2004);
                            logger.info("该核定流水已缴费，请勿重复缴费");
                            throw new TracedException(2004, "该核定流水已缴费，请勿重复缴费", "该核定流水已缴费，请勿重复缴费");
                        case 400:
                            result.setErrorCode(400);
                            logger.info(result.getResMsg());
                            throw new BusiException(result.getResMsg());
                        case 500:
                            result.setErrorCode(500);
                            logger.info(result.getResMsg());
                            throw new BusiException("缴费通知出现异常！");
                    }
                case SERVICE_M20101:
                    switch(result.getErrorCode()){
                        case 2006:
                            result.setErrorCode(2006);
                            logger.info("个人参保状态为未参保");
                            throw new TracedException(2006, "个人参保状态为未参保", "个人参保状态为未参保");
                        case 2001:
                            result.setErrorCode(2001);
                            logger.info("个人缴费状态异常，为停保或注销状态");
                            throw new TracedException(2001, "个人缴费状态异常，为停保或注销状态", "个人缴费状态异常，为停保或注销状态");
                        case 2005:
                            result.setErrorCode(2005);
                            logger.info("个人当前业务期已缴费，无欠费记录");
                            throw new TracedException(2005, "个人当前业务期已缴费，无欠费记录", "个人当前业务期已缴费，无欠费记录");
                        case 2002:
                            result.setErrorCode(2002);
                            logger.info("个人存在历史欠费，需要临柜处理");
                            throw new TracedException(2002, "个人存在历史欠费，需要临柜处理", "个人存在历史欠费，需要临柜处理");
                        case 2007:
                            result.setErrorCode(2007);
                            logger.info("姓名或身份证输入有误！");
                            throw new TracedException(2007, "姓名或身份证输入有误！", "姓名或身份证输入有误！");
                        case 400:
                            result.setErrorCode(400);
                            logger.info(result.getResMsg());
                            throw new BusiException(result.getResMsg());
                        case 500:
                            result.setErrorCode(500);
                            logger.info(result.getResMsg());
                            throw new BusiException("缴费查询出现异常！");
                    }
                case SERVICE_M20102:
                    switch(result.getErrorCode()){
                        case 2003:
                            result.setErrorCode(2003);
                            logger.info("此人核定记录已被其他缴费渠道锁定");
                            throw new TracedException(2003, "此人核定记录已被其他缴费渠道锁定", "此人核定记录已被其他缴费渠道锁定");
                        case 400:
                            result.setErrorCode(400);
                            logger.info(result.getResMsg());
                            throw new BusiException(result.getResMsg());
                        case 500:
                            result.setErrorCode(500);
                            logger.info(result.getResMsg());
                            throw new BusiException("缴费锁定出现异常！");
                    }
            }
        }
    }
}
