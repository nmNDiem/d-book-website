package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.PublisherRequest;
import com.nmnd.d_book_backend.dto.response.PublisherResponse;
import com.nmnd.d_book_backend.entity.Publisher;
import com.nmnd.d_book_backend.mapper.PublisherMapper;
import com.nmnd.d_book_backend.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepo;
    @Autowired
    private PublisherMapper publisherMapper;

    public PublisherResponse createPublisher(PublisherRequest request) {
        Publisher publisher = publisherMapper.toPublisher(request);
        publisher = publisherRepo.save(publisher);

        return publisherMapper.toPublisherResponse(publisher);
    }

    public List<PublisherResponse> getAllPublisher() {
        var publishers = publisherRepo.findAll();

        return publishers.stream().map(publisherMapper::toPublisherResponse).toList();
    }

    public void deletePublisher(int id) {
        publisherRepo.deleteById(id);
    }
}
