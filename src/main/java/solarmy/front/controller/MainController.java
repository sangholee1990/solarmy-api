package solarmy.front.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import solarmy.front.common.ServiceHelper;
import solarmy.front.model.MainDAO;
import solarmy.front.vo.*;

@RestController
public class MainController extends ServiceHelper {

    @Autowired
    MainDAO mainDao;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @ApiOperation(value = "(조회) 공통 코드", notes = "공통 코드 목록을 조회합니다.")
    @GetMapping(value = "/api/sel-commCode")
    public ResponseEntity<String> sel_commCode(HttpServletRequest request, @ModelAttribute CommCodeVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selCommCode, new String[]{});
    }

    @ApiOperation(value = "(조회) 회원정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-member")
    public ResponseEntity<String> selMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selMember, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(조회) 기상 외부 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-outputData")
    public ResponseEntity<String> selOutputData(HttpServletRequest request, @ModelAttribute OutputDataVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selOutputData, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(조회) IOT 제품 인증", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-iotProdtAuth")
    public ResponseEntity<String> selIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selIotProdtAuth, new String[]{"product_serial_number"});
    }

    @ApiOperation(value = "(조회) 한전API 제품 인증", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-kepProdtAuth")
    public ResponseEntity<String> selKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selKepProdtAuth, new String[]{"kepco_api_key"});
    }

    @ApiOperation(value = "(조회) 메시지 정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-msgInfo")
    public ResponseEntity<String> selMsgInfo(HttpServletRequest request, @ModelAttribute MsgInfoVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selMsgInfo, new String[]{});
    }

    @ApiOperation(value = "(조회) 시스템 정보", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-sysInfo")
    public ResponseEntity<String> selSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selSysInfo, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(조회) IOT 내부 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-inputData")
    public ResponseEntity<String> selInputData(HttpServletRequest request, @ModelAttribute InputDataVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selInputData, new String[]{"product_serial_number"});
    }

    @ApiOperation(value = "(조회) 기상 외부 통계 데이터", notes = "특정 조건에 맞는 정보를 조회합니다.")
    @GetMapping(value = "/api/sel-outputStatData")
    public ResponseEntity<String> selOutputStatData(HttpServletRequest request, @ModelAttribute OutputStatDataVO vo) throws Exception {
        return selHelper(request, vo, mainDao::selOutputStatData, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(등록) 회원정보", notes = "회원정보를 등록합니다.")
    @PostMapping(value = "/api/ins-member")
    public ResponseEntity<String> insMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::insMember, null);
    }

    @ApiOperation(value = "(등록) 시스템 정보", notes = "시스템 정보를 등록합니다.")
    @PostMapping(value = "/api/ins-sysInfo")
    public ResponseEntity<String> insSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::insSysInfo, null);
    }

    @ApiOperation(value = "(등록) 약관 동의", notes = "약관 동의를 등록합니다.")
    @PostMapping(value = "/api/ins-termsCond")
    public ResponseEntity<String> insTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::insTermsCond, null);
    }

    @ApiOperation(value = "(등록) 한전API 제품 인증", notes = "한전API 제품 인증을 등록합니다.")
    @PostMapping(value = "/api/ins-kepProdtAuth")
    public ResponseEntity<String> insKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::insKepProdtAuth, null);
    }

    @ApiOperation(value = "(등록) IOT 제품 인증", notes = "IOT 제품 인증을 등록합니다.")
    @PostMapping(value = "/api/ins-iotProdtAuth")
    public ResponseEntity<String> insIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::insIotProdtAuth, null);
    }

    @ApiOperation(value = "(수정) 한전API 제품 인증", notes = "한전API 제품 인증을 수정합니다.")
    @PutMapping(value = "/api/upd-kepProdtAuth")
    public ResponseEntity<String> updKepProdtAuth(HttpServletRequest request, @ModelAttribute KepcoApiAuthVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::updKepProdtAuth, new String[]{"kepco_api_key"});
    }

    @ApiOperation(value = "(수정) IOT 제품 인증", notes = "IOT 제품 인증을 수정합니다.")
    @PutMapping(value = "/api/upd-iotProdtAuth")
    public ResponseEntity<String> updIotProdtAuth(HttpServletRequest request, @ModelAttribute IotPrdctAuthVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::updIotProdtAuth, new String[]{"product_serial_number"});
    }

    @ApiOperation(value = "(수정) 회원정보", notes = "customer_link_number를 이용하여 회원정보를 수정합니다.")
    @PutMapping(value = "/api/upd-member")
    public ResponseEntity<String> updMember(HttpServletRequest request, @ModelAttribute MemberVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::updMember, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(수정) 시스템 정보", notes = "customer_link_number를 이용하여 시스템 정보를 수정합니다.")
    @PutMapping(value = "/api/upd-sysInfo")
    public ResponseEntity<String> updSysInfo(HttpServletRequest request, @ModelAttribute SysInfoVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::updSysInfo, new String[]{"customer_link_number"});
    }

    @ApiOperation(value = "(수정) 약관 동의", notes = "customer_link_number를 이용하여 약관 동의를 수정합니다.")
    @PutMapping(value = "/api/upd-termsCond")
    public ResponseEntity<String> updTermsCond(HttpServletRequest request, @ModelAttribute TermsCondVO vo) throws Exception {
        return mergeHelper(request, vo, mainDao::updTermsCond, new String[]{"customer_link_number"});
    }
}