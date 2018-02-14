package pl.arek.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arek.jba.entity.Blog;
import pl.arek.jba.entity.Item;
import pl.arek.jba.entity.Role;
import pl.arek.jba.entity.User;
import pl.arek.jba.repository.BlogRepository;
import pl.arek.jba.repository.ItemRepository;
import pl.arek.jba.repository.RoleRepository;
import pl.arek.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blogJavaVid = new Blog();
        blogJavaVid.setName("JavaVid");
        blogJavaVid.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJavaVid.setUser(userAdmin);
        blogRepository.save(blogJavaVid);

        Item item1 = new Item();
        item1.setBlog(blogJavaVid);
        item1.setTitle("first");
        item1.setLink("http://www.javavid.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogJavaVid);
        item2.setTitle("second");
        item2.setLink("http://www.javavid.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);
    }

}
