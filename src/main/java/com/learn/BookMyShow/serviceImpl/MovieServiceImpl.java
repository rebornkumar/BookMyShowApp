package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.entity.Movie;
import com.learn.BookMyShow.repository.MovieRepo;
import com.learn.BookMyShow.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Optional;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public ResponseDto createMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        ResponseDto responseDto = new ResponseDto("success","movie created successfully!!");
        if(StringUtils.isEmpty(movieDto.getMovieCode()) ||StringUtils.isEmpty(movieDto.getMovieTitle()) || StringUtils.isEmpty(movieDto.getLanguage()) ||StringUtils.isEmpty(movieDto.getReleaseDate())) {
            responseDto.setStatus("failed");
            responseDto.setMessage("parameters cannot have empty values");
            log.info("missing paramters for movie creation");
        }
        else {
            Optional<Movie> oldMovie = movieRepo.findByMovieCode(movieDto.getMovieCode());
            if(oldMovie.isPresent()) {
                oldMovie.get().setTitle(movieDto.getMovieTitle());
                oldMovie.get().setLanguage(movieDto.getLanguage());
                oldMovie.get().setReleaseDate(movieDto.getReleaseDate());
                responseDto.setStatus("updating movie");
                responseDto.setMessage("movie updated in database for movieCode : "+ oldMovie.get().getMovieCode() +" and movieTitle : " + oldMovie.get().getTitle());
                log.info("movie updated in database for movieCode : {} and movieTitle : {} ",oldMovie.get().getMovieCode(),oldMovie.get().getTitle());
            }
            else {
                movie.setMovieCode(movieDto.getMovieCode());
                movie.setTitle(movieDto.getMovieTitle());
                movie.setLanguage(movieDto.getLanguage());
                movie.setReleaseDate(movieDto.getReleaseDate());
                movieRepo.save(movie);
                log.info("Movie details saved to database successfully with movieId : {}",movie.getId());
            }

        }
        return responseDto;
    }
}
