package com.uam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uam.entity.Circle;
import com.uam.entity.CityMstr;
import com.uam.entity.CityZoneMstr;
import com.uam.entity.ProductLobMaster;
import com.uam.entity.ProductMSTR;
import com.uam.entity.ZoneMstr;
import com.uam.service.MasterService;
import com.uam.util.RestURIConstants;

@RestController
@RequestMapping("UAM")
//@CrossOrigin(origins = "http://localhost:4200")
public class BaseController {
	
	@Autowired
	MasterService masterService;
	
	
	@RequestMapping(value = "/lob", method = RequestMethod.GET)
    public ResponseEntity<List<ProductLobMaster>> listAllUsers() {
		List<ProductLobMaster> productMasters = masterService.fetchAllProductLob();
        if (productMasters.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<ProductLobMaster>>(productMasters, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET , headers="Accept=application/json")
	public List<ProductLobMaster> leadSubmitt() {
		ProductLobMaster  lobMaster  = new ProductLobMaster();
		try {
			lobMaster.setId(1);
			lobMaster.setProductLobName("Mobility");
			System.out.println("------------------beeru===="+masterService.fetchAllProductLob());
			List<ProductLobMaster> productMasters = masterService.fetchAllProductLob();
			return productMasters;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = RestURIConstants.GET_ALLLOB_URL, method = RequestMethod.GET  )
	public List<ProductLobMaster>  fetchAllLob() {
		try {
			//System.out.println("------------------beeru====");
			List<ProductLobMaster> productMasters =	masterService.fetchAllProductLob();
			
			//ResponseEntity<List<ProductLobMaster>> responseEntity  = new ResponseEntity<List<ProductLobMaster>>(productMasters,HttpStatus.OK);
			//LeadStatus leadStatus  = masterService.findById(200);
			
			return productMasters;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALLPRODUCT_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<ProductMSTR>  fetchAllProducts() {
		try {
			//System.out.println("------------------beeru===="+masterService.fetchAllProduct());
			List<ProductMSTR> productMasters =	masterService.fetchAllProduct();
			//ResponseEntity<List<ProductMSTR>> responseEntity  = new ResponseEntity<List<ProductMSTR>>(productMasters,HttpStatus.OK);
			
			return productMasters;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_PRODUCTBYLOB_ID_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<ProductMSTR>  fetchProductsBYLob(@PathVariable("lobId") int lobId) {
		try {
			//System.out.println("------------------beeru===="+masterService.fetchCircleByLOB(lobId));
			List<ProductMSTR> productMasters =	masterService.fetchProductByLOB(lobId);
			System.out.println("-----------------"+productMasters.size());
			//ResponseEntity<List<ProductMSTR>> responseEntity  = new ResponseEntity<List<ProductMSTR>>(productMasters,HttpStatus.OK);
			
			return productMasters;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_CIRCLE_LOBBY_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<Circle>  findCircleByLob(@PathVariable("lob") int lobId) {
		try {
			List<Circle> circles =	masterService.fetchCircleByLOB(lobId);
			return circles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ZONE_BYCIRCLE_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<ZoneMstr> findZoneByCircle(@PathVariable("circle") int circlemstrId) {
		try {
			List<ZoneMstr> zones =	masterService.fetchZoneByCircleMstrId(circlemstrId);
			return zones;
		} catch (Exception e) {
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_CITY_BYZONE_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<CityMstr> findCityByZone(@PathVariable("zone") String zoneCode) {
		try {
			List<CityMstr> cityMstrs =	masterService.findCityByZoneCode(zoneCode);
			return cityMstrs;
		} catch (Exception e) {
		}
		return null;
	}
	
	@RequestMapping(value = RestURIConstants.GET_CITY_ZONE_BYCITY_URL, method = RequestMethod.GET  , headers="Accept=application/json")
	public List<CityZoneMstr> findCityZoneByCity(@PathVariable("city") String cityCode) {
		try {
			List<CityZoneMstr> cityMstrs =	masterService.findCityZoneByCityCode(cityCode);
			return cityMstrs;
		} catch (Exception e) {
		}
		return null;
	}
}
/**
 * 
 * 
 * @Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	@GetMapping("article")
	public ResponseEntity<Article> getArticleById(@RequestParam("id") String id) {
		Article article = articleService.getArticleById(Integer.parseInt(id));
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@GetMapping("all-articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	@PostMapping("article")
	public ResponseEntity<Void> createArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = articleService.createArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article")
	public ResponseEntity<Void> deleteArticle(@RequestParam("id") String id) {
		articleService.deleteArticle(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
 * 
 * 
 * 
 * 
 */
