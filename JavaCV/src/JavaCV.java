import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;
import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_calib3d.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class JavaCV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IplImage img1, imghsv, imgbin;
		img1 = cvLoadImage("color.jpg");
		imghsv = cvCreateImage(cvGetSize(img1),8,3);
		imgbin = cvCreateImage(cvGetSize(img1),8,1);
		cvCvtColor(img1,imghsv,CV_BGR2HSV);
		CvScalar minc = cvScalar(160, 150, 75, 0), maxc = cvScalar(180, 255, 255, 0);
		cvInRangeS(imghsv, minc,maxc,imgbin);
		
		cvShowImage("Color", img1);
		cvShowImage("Binary", imgbin);
		cvWaitKey();
		
		cvReleaseImage(img1);
		cvReleaseImage(imghsv);
		cvReleaseImage(imgbin);
	}

}
