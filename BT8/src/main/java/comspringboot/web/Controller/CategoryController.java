package comspringboot.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import comspringboot.web.Entity.CategoryEntity;
import comspringboot.web.Repository.CategoryRepository;

@Controller
//@RequestMapping("/user/categories")
public class CategoryController {
	@Autowired 
	private CategoryRepository categoryRepository;
	
	public CategoryEntity createCategory(CategoryEntity category) {
		return categoryRepository.save(category);
	}
	
}
	
	
//	@Value("${file.upload-dir:images/}")
//    private String UPLOAD_DIR;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @GetMapping
//    public String listCategories(Model model) {
//        model.addAttribute("categories", categoryRepository.findAll());
//        model.addAttribute("category", new CategoryEntity());
//        
//        return "user/category-form";
//    }
//
//    @PostMapping("/add")
//    public String addCategory(@Validated @ModelAttribute CategoryEntity category,
//                             BindingResult result,
//                             @RequestParam("imageFile") MultipartFile imageFile,
//                             RedirectAttributes redirectAttributes,
//                             Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("categories", categoryRepository.findAll());
//            model.addAttribute("error", "Invalid category data.");
//            return "user/category-form";
//        }
//
//        if (!imageFile.isEmpty()) {
//        	String contentType = imageFile.getContentType();
//            if (contentType == null || !contentType.startsWith("image/")) {
//                model.addAttribute("categories", categoryRepository.findAll());
//                model.addAttribute("error", "Chỉ được tải lên file hình ảnh.");
//                return "user/category-form";
//            }
//            try {
//                String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
//                Path filePath = Paths.get(UPLOAD_DIR + fileName);
//                Files.createDirectories(filePath.getParent());
//                Files.write(filePath, imageFile.getBytes());
//                category.setImageUrl(fileName);
//            } catch (IOException e) {
//                model.addAttribute("categories", categoryRepository.findAll());
//                model.addAttribute("error", "Tải hình ảnh thất bại: " + e.getMessage());
//                return "user/category-form";
//            }
//        }
//
//        categoryRepository.save(category);
//        redirectAttributes.addFlashAttribute("message", "Thêm danh mục thành công!");
//        return "redirect:/user/categories";
//    }
//    @PostMapping("/update")
//    public String updateCategory(@Validated @ModelAttribute CategoryEntity category,
//                                BindingResult result,
//                                @RequestParam("imageFile") MultipartFile imageFile,
//                                @RequestParam(value = "existingImageUrl", required = false) String existingImageUrl,
//                                RedirectAttributes redirectAttributes,
//                                Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("categories", categoryRepository.findAll());
//            model.addAttribute("error", "Dữ liệu danh mục không hợp lệ.");
//            return "user/category-form";
//        }
//
//        if (!imageFile.isEmpty()) {
//            String contentType = imageFile.getContentType();
//            if (contentType == null || !contentType.startsWith("image/")) {
//                model.addAttribute("categories", categoryRepository.findAll());
//                model.addAttribute("error", "Chỉ được tải lên file hình ảnh.");
//                return "user/category-form";
//            }
//            try {
//                String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
//                Path filePath = Paths.get(UPLOAD_DIR + fileName);
//                Files.createDirectories(filePath.getParent());
//                Files.write(filePath, imageFile.getBytes());
//                category.setImageUrl(fileName);
//
//                if (existingImageUrl != null && !existingImageUrl.isEmpty()) {
//                    Files.deleteIfExists(Paths.get(UPLOAD_DIR + existingImageUrl));
//                }
//            } catch (IOException e) {
//                model.addAttribute("categories", categoryRepository.findAll());
//                model.addAttribute("error", "Tải hình ảnh thất bại: " + e.getMessage());
//                return "user/category-form";
//            }
//        } else {
//            category.setImageUrl(existingImageUrl);
//        }
//
//        categoryRepository.save(category);
//        redirectAttributes.addFlashAttribute("message", "Cập nhật danh mục thành công!");
//        return "redirect:/user/categories";
//    }
//
//    @PostMapping("/delete")
//    public String deleteCategory(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
//        if (categoryRepository.existsById(id)) {
//            String imageUrl = categoryRepository.findById(id).map(CategoryEntity::getImageUrl).orElse(null);
//            categoryRepository.deleteById(id);
//            if (imageUrl != null && !imageUrl.isEmpty()) {
//                try {
//                    Files.deleteIfExists(Paths.get(UPLOAD_DIR + imageUrl));
//                } catch (IOException e) {
//                    redirectAttributes.addFlashAttribute("error", "Xóa hình ảnh thất bại: " + e.getMessage());
//                }
//            }
//            redirectAttributes.addFlashAttribute("message", "Xóa danh mục thành công!");
//        } else {
//            redirectAttributes.addFlashAttribute("error", "Không tìm thấy danh mục để xóa.");
//        }
//        return "redirect:/user/categories";
//    }
//}
