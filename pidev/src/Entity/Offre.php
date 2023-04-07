<?php

namespace App\Entity;
use App\Repository\OffreRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: OffreRepository::class)]
class Offre
{
    /**
     * @return int
     */
    public function getIdOffre(): int
    {
        return $this->idOffre;
    }

    /**
     * @param int $idOffre
     */
    public function setIdOffre(int $idOffre): void
    {
        $this->idOffre = $idOffre;
    }

    /**
     * @return string
     */
    public function getDescriptionOf(): string
    {
        return $this->descriptionOf;
    }

    /**
     * @param string $descriptionOf
     */
    public function setDescriptionOf(string $descriptionOf): void
    {
        $this->descriptionOf = $descriptionOf;
    }
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $idOffre=null;

    #[ORM\Column]
    #[Assert\NotBlank(message: 'Enter an offer description please')]
    #[Assert\Length(min: 7, max: 10000, minMessage: 'The description must be more than 7 words .', maxMessage: 'and must be less than 1000 word')]
    private ?string $descriptionOf=null;


}
