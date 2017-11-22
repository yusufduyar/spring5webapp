package com.springfwcourse.spring5webapp.repositories;

import com.springfwcourse.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
